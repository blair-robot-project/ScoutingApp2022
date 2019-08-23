package team449.frc.scoutingappbase.helpers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import team449.frc.scoutingappbase.model.Data


fun serialize(data: Any) = Gson().toJson(data)

fun deserialize(json: String): Data = Gson().fromJson(json, object : TypeToken<Data>(){}.type)