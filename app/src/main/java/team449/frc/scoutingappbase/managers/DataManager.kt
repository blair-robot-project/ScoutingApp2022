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
    private var data = Data(HashMap(), Stack())

    init {
        load()
    }

    fun submit(match: MatchShadow) {
        val key = match.timestamp.toString()
        if (!data.submitted.containsKey(key)) {
            data.submitted[key] = ArrayList()
        }
        data.submitted[key]!!.add(match)
        AsyncTask.execute(this::save)
    }

    fun stashCurrent(match: MatchShadow) { data.partial.push(match) }

    fun retrieveMatch(id: String) = data.submitted[id]?.last()

    fun recoverMatch() = if (data.partial.empty()) null else data.partial.pop()

    val matchNames: List<Pair<String,String>>
        get() = data.submitted.map { it.value.last() }.sortedByDescending { it.matchId }
                .map { Pair("${Conversions.spinnerToMatch(it.matchId)}, ${Conversions.spinnerToTeam(it.teamId)}", it.timestamp.toString()) }

    fun sync(summary: Map<String,Double>): List<MatchShadow> =
        data.submitted.filter { (id, revs) -> !summary.containsKey(id.toString()) || summary[id.toString()]?.toInt() ?: 0 < revs.size - 1}
                      .map { (_, revs) -> revs.last() }

    private fun save() {
        writeToFile(dataFile, serialize(data))
    }

    private fun load() {
        readFromFile(dataFile)?.let{ data = deserializeData(it) }
    }

    fun clear() {
        clearFile(dataFile)
        data.submitted.clear()
        data.partial.clear()
    }
}