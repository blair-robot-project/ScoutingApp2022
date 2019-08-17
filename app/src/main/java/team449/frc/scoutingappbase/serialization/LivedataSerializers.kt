package team449.frc.scoutingappbase.serialization

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.*
import java.lang.reflect.Type


// Unfortunately these can't be one generic class because JsonPrimitive needs to know if its an int, string or bool,
//  and json.asJsonPrimitive.as[type] needs it too. Could maybe to it in cases by type, but that seems worse

class LivedataIntSerializer: JsonSerializer<MutableLiveData<Int>>, JsonDeserializer<MutableLiveData<Int>> {
    override fun serialize(
        src: MutableLiveData<Int>,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ) = JsonPrimitive(src.value)

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ) = MutableLiveData<Int>().apply { json.asJsonPrimitive.asInt }
}

class LivedataStringSerializer: JsonSerializer<MutableLiveData<String>>, JsonDeserializer<MutableLiveData<String>> {
    override fun serialize(
        src: MutableLiveData<String>,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ) = JsonPrimitive(src.value)

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ) = MutableLiveData<String>().apply { json.asJsonPrimitive.asString }
}

class LivedataBooleanSerializer: JsonSerializer<MutableLiveData<Boolean>>, JsonDeserializer<MutableLiveData<Boolean>> {
    override fun serialize(
        src: MutableLiveData<Boolean>,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonPrimitive {
        Log.i("value", src.value.toString())
        Log.i("bool", (src.value==true).toString())
        return JsonPrimitive(if (src.value == true) 1 else 0)
    }

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ) = MutableLiveData<Boolean>().apply { json.asJsonPrimitive.asInt != 0 }
}
