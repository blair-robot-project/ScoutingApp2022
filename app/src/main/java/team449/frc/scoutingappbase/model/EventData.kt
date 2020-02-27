package team449.frc.scoutingappbase.model

import androidx.lifecycle.MutableLiveData

object EventData {

    private var elimsMatches = arrayOf("Quarters", "Semis", "Finals")
    private var defaultMatches = (1..99).map { it.toString() }.toTypedArray() + elimsMatches
    private var defaultTeams = arrayOf("No team data") + (1..6).map{ "testteam$it" }.toTypedArray()

    var matchSchedule: Map<String, Map<String, List<String>>>? = null
        set(value) {
            field = value
            matches = (value?.keys?.filter{ it.matches("-?\\d+(\\.\\d+)?".toRegex()) }?.sortedBy { it.toInt() }?.toTypedArray()?.plus(
                elimsMatches
            ))?: defaultMatches
        }
    lateinit var matches: Array<String>
    lateinit var teams: Array<String>

    fun resetEventData() {
        matches = defaultMatches
        teams = defaultTeams
    }

    init {
        resetEventData()
    }
}