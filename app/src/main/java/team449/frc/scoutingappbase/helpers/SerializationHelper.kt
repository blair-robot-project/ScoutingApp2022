package team449.frc.scoutingappbase.helpers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import team449.frc.scoutingappbase.model.Data
import team449.frc.scoutingappbase.model.Message


fun serialize(data: Any) = Gson().toJson(data)

// fun <T> deserialize(json: String): T = Gson().fromJson(json, object : TypeToken<T>() { }.type)

// Generic deserialize isn't working, not sure why
fun deserializeData(json: String): Data = Gson().fromJson(json, object : TypeToken<Data>() { }.type)
fun deserializeMessage(json: String): Message = Gson().fromJson(json, object : TypeToken<Message>() { }.type)