package team449.frc.scoutingappbase.managers

import android.util.Log
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import team449.frc.scoutingappbase.helpers.deserializeMessage
import team449.frc.scoutingappbase.helpers.saveMatchSchedule
import team449.frc.scoutingappbase.helpers.saveTeams
import team449.frc.scoutingappbase.model.*

object MessageHandler {
    private val msgStrings = mutableListOf<String>()

    fun handleRawMessage(string: String) {
        msgStrings += string
        messagesToValidMessage(msgStrings)
            ?.let{
            handleMessage(it)
            msgStrings.clear()
        }
    }

    // TODO: find a better way to handle casting
    private fun handleMessage(message: Message) {
        GlobalScope.launch {
            try {
                when (message.type) {
                    MessageType.SYNC_SUMMARY.name -> DataManager.sync(message.body as Map<String, Double>).let {
                        BluetoothManager.write(makeMultiMatchDataMessage(it))
                    }
                    MessageType.SCHEDULE.name -> {
                        GlobalResources.matchSchedule =
                            message.body as Map<String, Map<String, List<String>>>
                        saveMatchSchedule()
                    }
                    MessageType.TEAM_LIST.name -> {
                        GlobalResources.teams = (message.body as List<String>).sortedBy { it.toInt() }.toTypedArray()
                        saveTeams()
                    }
                    else -> Log.e("MsgHandler","Invalid message type received: ${message.type}")
                }
            } catch (e: ClassCastException) {
                Log.i("MsgHandler","ClassCastException in ${message.type} cast of: ${message.body}")
            }
        }
    }

    private fun handleJsonNonMessage(message: String) {
        BluetoothManager.write(makeErrorMessage("Invalid message received: $message"))
    }


    // Large messages get split up over multiple buffers, this puts them together
    private fun messagesToValidMessage(msgStrings: List<String>): Message? {
        if (msgStrings.isEmpty()) return null
        val full = msgStrings.joinToString(separator = "") { it }
        return try {
            val message = deserializeMessage(full)
            // Gson is able to break Kotlin's non-nullable types, and if the json isn't in the right format for message,
            //  it will just put nulls. Ignore the IDE warning, it's wrong.
            if (message.type == null || message.body == null) throw ClassCastException()
            message
        } catch (e: JsonSyntaxException) {
            // Invalid json. Most likely, the message just isn't finished, but it could be that a corrupted message
            //  preceded a full and valid message. We want to find that valid message
            messagesToValidMessage(
                msgStrings.drop(
                    1
                )
            )
        } catch (e: ClassCastException) {
            // Valid json, but not a message. Could be that its an intermediate segment that just happened to be valid
            //  on its own, but if this is all there is in the stack, we know it's an error
            Log.e("BtM.receive","Json message received isn't a message (ClassCast)\n${msgStrings.last()}")
            if (MessageHandler.msgStrings.size == 1) {
                handleJsonNonMessage(msgStrings.last())
            }
            messagesToValidMessage(
                msgStrings.drop(
                    1
                )
            )
        }
    }
}