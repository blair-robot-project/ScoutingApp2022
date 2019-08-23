package team449.frc.scoutingappbase

import android.util.Log
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.MessageFactory


object DataManager {
    private val submittedData: MutableMap<String, MutableSet<MatchShadow>> = HashMap()

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
        Log.i("submittedData", MessageFactory.serialize(submittedData))
    }
}