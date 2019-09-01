package team449.frc.scoutingappbase.helpers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import team449.frc.scoutingappbase.model.Message


fun serialize(data: Any) = Gson().toJson(data)

fun <T> deserialize(json: String): T = Gson().fromJson(json, object : TypeToken<T>() { }.type)

// Generic doesn't work for Message. No idea why.
fun deserializeMessage(json: String): Message = Gson().fromJson(json, object : TypeToken<Message>() { }.type)