package team449.frc.scoutingappbase.helpers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import team449.frc.scoutingappbase.model.MatchShadow


fun serialize(data: Any) = Gson().toJson(data)

private val type = object : TypeToken<MutableMap<String, MutableMap<String, MatchShadow>>>() { }.type

fun deserialize(json: String): MutableMap<String, MutableMap<String, MatchShadow>> {
    return Gson().fromJson(json, type)
}