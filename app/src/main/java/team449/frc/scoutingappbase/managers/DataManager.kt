package team449.frc.scoutingappbase.managers

import android.os.AsyncTask
import android.util.Log
import team449.frc.scoutingappbase.helpers.deserialize
import team449.frc.scoutingappbase.helpers.readFromFile
import team449.frc.scoutingappbase.helpers.serialize
import team449.frc.scoutingappbase.helpers.writeToFile
import team449.frc.scoutingappbase.model.Data
import team449.frc.scoutingappbase.model.MatchShadow


object DataManager {
    private const val saveFile = "data.json"
    private var data = Data(HashMap(), ArrayList())

    fun submit(match: MatchShadow) {
        val key = match.timestamp.toString()
        var revMap = data.submitted[key]
        if (revMap == null) {
            revMap = HashMap()
            data.submitted[key] = revMap
        }
        revMap[match.revision.toString()] = match
        AsyncTask.execute(this::save)
    }

    fun logSerialized() {
        Log.i("submittedData", serialize(data))
    }

    fun save() {
        writeToFile(saveFile, serialize(data))
    }

    fun load() {
        val f = readFromFile(saveFile)
        if (f != null) data = deserialize(f)
    }
}