package team449.frc.refereeappbase.model

import androidx.lifecycle.MutableLiveData

object EventData {

    private var elimsMatches = arrayOf("Quarters", "Semis", "Finals")
    private var defaultMatches = (1..99).map { it.toString() }.toTypedArray() + elimsMatches
    private var defaultTeams = arrayOf("No team data") + (1..6).map{ "testteam$it" }.toTypedArray()

    var matchSchedule: Map<String, Map<String, List<String>>>? = null
        set(value) {
            field = value
            matches.postValue((value?.keys?.filter{ it.matches("-?\\d+(\\.\\d+)?".toRegex()) }?.sortedBy { it.toInt() }?.toTypedArray()?.plus(
                elimsMatches
            ))?: defaultMatches)
        }
    lateinit var matches: MutableLiveData<Array<String>>
    lateinit var teams: MutableLiveData<Array<String>>

    fun resetEventData() {
        matches = MutableLiveData<Array<String>>().apply { postValue(defaultMatches) }
        teams = MutableLiveData<Array<String>>().apply { postValue(defaultTeams) }
    }

    init {
        resetEventData()
    }
}