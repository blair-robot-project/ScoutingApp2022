package team449.frc.scoutingappbase

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.MatchViewModel
import team449.frc.scoutingappbase.serialization.LivedataBooleanSerializer
import team449.frc.scoutingappbase.serialization.LivedataIntSerializer
import team449.frc.scoutingappbase.serialization.LivedataStringSerializer
import kotlin.reflect.KTypeProjection
import kotlin.reflect.full.createType
import kotlin.reflect.full.starProjectedType
import kotlin.reflect.jvm.javaType


inline fun <reified T> genericType() = object: TypeToken<T>() {}.type

object MessageFactory {
    fun serialize(model: MatchViewModel): String {
        return Gson().toJson(MatchShadow(model.match))
//        val gson = GsonBuilder()

//        val nonNullIntType = Int::class.starProjectedType
//        val intProjection = KTypeProjection.invariant(nonNullIntType)
//        val MLDIntType = MutableLiveData::class.createType(listOf(intProjection))
//
//        val nonNullStringType = String::class.starProjectedType
//        val stringProjection = KTypeProjection.invariant(nonNullStringType)
//        val MLDStringType = MutableLiveData::class.createType(listOf(stringProjection))
//
//        val nonNullBooleanType = Boolean::class.starProjectedType
//        val booleanProjection = KTypeProjection.invariant(nonNullBooleanType)
//        val MLDBooleanType = MutableLiveData::class.createType(listOf(booleanProjection))

//        gson.registerTypeAdapter(genericType<MutableLiveData<Int>>().javaClass, LivedataIntSerializer())
//        gson.registerTypeAdapter(genericType<MutableLiveData<String>>().javaClass, LivedataStringSerializer())
//        gson.registerTypeAdapter(genericType<MutableLiveData<Boolean>>().javaClass, LivedataBooleanSerializer())
//        return gson.create().toJson(model.match)
    }
}