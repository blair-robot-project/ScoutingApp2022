package team449.frc.scoutingappbase.model

import team449.frc.scoutingappbase.helpers.serialize

enum class MessageType {
    DATA, MULTI, SYNC, ERROR, SYNC_SUMMARY, SCHEDULE, TEAM_LIST
}

data class Message(val type: String, val body: Any)


fun makeSerializedMessage(type: MessageType, body: Any): String = serialize(Message(type.name, body))

fun makeMatchDataMessage(model: MatchShadow) = makeSerializedMessage(MessageType.DATA, model)

fun makeMultiMatchDataMessage(list: List<MatchShadow>) = makeSerializedMessage(MessageType.MULTI, list)

fun makeErrorMessage(error: String) = makeSerializedMessage(MessageType.ERROR, error)

fun makeSyncRequest() = makeSerializedMessage(MessageType.SYNC,"")