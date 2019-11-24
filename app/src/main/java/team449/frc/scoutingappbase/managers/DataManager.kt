package team449.frc.scoutingappbase.managers

import android.os.AsyncTask
import android.util.Log
import team449.frc.scoutingappbase.databinding.Conversions
import team449.frc.scoutingappbase.helpers.deserialize
import team449.frc.scoutingappbase.helpers.readFromFile
import team449.frc.scoutingappbase.helpers.serialize
import team449.frc.scoutingappbase.helpers.writeToFile
import team449.frc.scoutingappbase.model.Data
import team449.frc.scoutingappbase.model.MatchShadow
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


object DataManager {
    private const val saveFile = "data.json"
    private var data = Data(HashMap(), Stack())

    fun submit(match: MatchShadow) {
        val key = match.timestamp
        if (!data.submitted.containsKey(key)) {
            data.submitted[key] = ArrayList()
        }
        data.submitted[key]!!.add(match)
        AsyncTask.execute(this::save)
    }

    fun stashCurrent(match: MatchShadow) { data.partial.push(match) }

    fun retrieveMatch(id: Long) = data.submitted[id]?.last()

    fun recoverMatch() = if (data.partial.empty()) null else data.partial.pop()

    val matchNames: List<Pair<String,Long>>
        get() = data.submitted.map { it.value.last() }.sortedByDescending { it.matchId }
                .map { Pair("${Conversions.spinnerToMatch(it.matchId)}, ${Conversions.spinnerToTeam(it.teamId)}", it.timestamp) }

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