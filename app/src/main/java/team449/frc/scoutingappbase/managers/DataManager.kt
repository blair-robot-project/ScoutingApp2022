package team449.frc.scoutingappbase.managers

import android.util.Log
import team449.frc.scoutingappbase.helpers.deserialize
import team449.frc.scoutingappbase.helpers.serialize
import team449.frc.scoutingappbase.model.MatchShadow


object DataManager {
    private var submittedData: MutableMap<String, MutableSet<MatchShadow>> = HashMap()

    fun submit(data: MatchShadow) {
        val key = data.timestamp.toString()
        var set = submittedData[key]
        if (set == null) {
            set = HashSet()
            submittedData[key] = set
        }
        set.add(data)
    }

    fun logSerialized() {
        Log.i("submittedData", serialize(submittedData))
    }

    fun load() {
        submittedData = deserialize(serialize(submittedData))
    }
}