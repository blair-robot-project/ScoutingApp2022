package team449.frc.scoutingappbase.model

import team449.frc.scoutingappbase.helpers.serialize
import java.math.BigInteger
import java.security.MessageDigest

enum class MessageType {
    DATA, SUMMARY, ERROR
}

data class Message(val type: String, val body: String, val checksum: String)


private fun genChecksum(body: String): String {
    // Should it catch NoSuchAlgorithmException?
    val enc = MessageDigest.getInstance("MD5")
    enc.update(body.toByteArray(), 0, body.length)
    return BigInteger(1, enc.digest()).toString(16)
}

fun makeSerializedMessage(type: MessageType, body: String): String =
    serialize(Message(type.name, body, genChecksum(body)))

fun makeMatchDataMessage(model: MatchShadow) = makeSerializedMessage(MessageType.DATA, serialize(model))

fun makeErrorMessage(error: String) = makeSerializedMessage(MessageType.ERROR, error)