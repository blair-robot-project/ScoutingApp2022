package team449.frc.scoutingappbase

import android.util.Log
import com.google.gson.JsonSyntaxException
import team449.frc.scoutingappbase.helpers.deserializeMessage
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.model.Message
import team449.frc.scoutingappbase.model.makeErrorMessage
import java.lang.ClassCastException

object MessageHandler {
    private val msgStrings = mutableListOf<String>()

    fun handleRawMessage(string: String) {
        msgStrings += string
        messagesToValidMessage(msgStrings)?.let{
            handleMessage(it)
            msgStrings.clear()
        }
    }

    private fun handleMessage(message: Message) {
        //TODO
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
            messagesToValidMessage(msgStrings.drop(1))
        } catch (e: ClassCastException) {
            // Valid json, but not a message. Could be that its an intermediate segment that just happened to be valid
            //  on its own, but if this is all there is in the stack, we know it's an error
            Log.e("BtM.receive","Json message received isn't a message (ClassCast)\n${msgStrings.last()}")
            if (this.msgStrings.size == 1) {
                handleJsonNonMessage(msgStrings.last())
            }
            messagesToValidMessage(msgStrings.drop(1))
        }
    }
}