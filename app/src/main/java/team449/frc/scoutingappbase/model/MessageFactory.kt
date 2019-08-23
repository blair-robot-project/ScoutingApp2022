package team449.frc.scoutingappbase.model

import com.google.gson.Gson
import java.math.BigInteger
import java.security.MessageDigest

enum class MessageType {
    DATA, SUMMARY
}

data class Message(val type: String, val body: String, val checksum: String)

object MessageFactory {

    private fun genChecksum(body: String): String {
        // Should I catch NoSuchAlgorithmException?
        val enc = MessageDigest.getInstance("MD5")
        enc.update(body.toByteArray(), 0, body.length)
        return BigInteger(1, enc.digest()).toString(16)
    }

    fun serialize(data: Any) = Gson().toJson(data)

    fun makeSerializedMessage(type: MessageType, body: String): String =
        serialize(Message(type.name, body, genChecksum(body)))

    fun makeMatchDataMessage(model: MatchShadow) = makeSerializedMessage(MessageType.DATA, serialize(model))
}