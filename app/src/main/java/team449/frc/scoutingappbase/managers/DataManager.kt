package team449.frc.scoutingappbase.managers

import android.os.AsyncTask
import android.util.Log
import team449.frc.scoutingappbase.helpers.deserialize
import team449.frc.scoutingappbase.helpers.readFromFile
import team449.frc.scoutingappbase.helpers.serialize
import team449.frc.scoutingappbase.helpers.writeToFile
import team449.frc.scoutingappbase.model.MatchShadow


object DataManager {
    private val saveFile = "data.json"
    private var submittedData: MutableMap<String, MutableMap<String, MatchShadow>> = HashMap()

    fun submit(data: MatchShadow) {
        val key = data.timestamp.toString()
        var match = submittedData[key]
        if (match == null) {
            match = HashMap()
            submittedData[key] = match
        }
        match[data.revision.toString()] = data
        AsyncTask.execute(this::save)
    }

    fun logSerialized() {
        Log.i("submittedData", serialize(submittedData))
    }

    fun save() {
        writeToFile(saveFile, serialize(submittedData))
    }

    fun load() {
        val data = readFromFile(saveFile)
        if (data != null) submittedData = deserialize(data)
    }
}