package team449.frc.refereeappbase.helpers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


fun serialize(data: Any): String = Gson().toJson(data)

inline fun <reified T> deserialize(json: String): T =
    Gson().fromJson(json, object : TypeToken<T>() {}.type)
