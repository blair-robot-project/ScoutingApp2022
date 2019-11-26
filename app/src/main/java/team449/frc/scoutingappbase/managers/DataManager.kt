package team449.frc.scoutingappbase.managers

import android.os.AsyncTask
import team449.frc.scoutingappbase.databinding.Conversions
import team449.frc.scoutingappbase.helpers.*
import team449.frc.scoutingappbase.model.Data
import team449.frc.scoutingappbase.model.MatchShadow
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


object DataManager {
    private const val saveFile = "data.json"
    private var data = Data(HashMap(), Stack())

    init {
        load()
    }

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

    private fun save() {
        writeToFile(saveFile, serialize(data))
    }

    private fun load() {
        readFromFile(saveFile)?.let{ data = deserializeData(it) }
    }

    fun clear() {
        clearFile(saveFile)
        data.submitted.clear()
        data.partial.clear()
    }
}