package team449.frc.refereeappbase.helpers

import android.util.Log
import team449.frc.refereeappbase.model.EventData
import team449.frc.refereeappbase.model.StaticResources
import java.io.File
import java.io.IOException


const val dataFile = "data.json"
const val teamsFile = "teams.json"
const val matchScheduleFile = "matches.json"


fun writeToFile(filename: String, data: String) {
    try {
        File(StaticResources.filesDir, filename).writeText(data)
    } catch (e: IOException) {
        e.printStackTrace()
        Log.e("writeToFile", "IOException while writing $filename")
    }
}

fun readFromFile(filename: String): String? =
    try {
        File(StaticResources.filesDir, filename).readText()
    } catch (e: IOException) {
        e.printStackTrace()
        Log.e("readFromFile", "IOException while reading $filename")
        null
    }


fun clearFile(filename: String) {
    writeToFile(filename,"")
}

fun saveMatchSchedule() {
    EventData.matchSchedule?.let { writeToFile(matchScheduleFile, serialize(it)) }
}
fun saveTeams(teams: Array<String>) {
    // Cannot save teams based on the value from EventData because postValue is threaded, so it might save the old data
    writeToFile(teamsFile, serialize(teams))
}