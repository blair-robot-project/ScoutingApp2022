package team449.frc.scoutingappbase.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

fun <T: Any?> mutableLiveData(initialValue: T) = MutableLiveData<T>().apply { postValue(initialValue) }

class MatchViewModel : ViewModel(){
    var timestamp: Long = 0

    lateinit var scoutName: MutableLiveData<String>
    lateinit var teamId : MutableLiveData<Int>
    lateinit var matchId: MutableLiveData<Int>
    lateinit var alliance: MutableLiveData<Int>
    lateinit var noShow: MutableLiveData<Boolean>
    lateinit var preload: MutableLiveData<Int>
    lateinit var autoMove: MutableLiveData<Boolean>
    lateinit var placedAThing: MutableLiveData<Boolean>
    lateinit var climbed: MutableLiveData<Boolean>
    lateinit var comments: MutableLiveData<String>

    init {
        scoutName = mutableLiveData("")
        matchId = mutableLiveData(0)
        alliance = mutableLiveData(-1)
        reset()
    }

    fun reset() {
        timestamp = System.currentTimeMillis()

        // Prematch
        teamId = mutableLiveData(0)
        matchId.value = matchId.value?.plus(1)
        noShow = mutableLiveData(false)
        preload = mutableLiveData(-1)

        // Auto
        autoMove = mutableLiveData(false)

        // Teleop
        placedAThing = mutableLiveData(false)

        // Endgame
        climbed = mutableLiveData(false)

        // General
        comments = mutableLiveData("")
    }
}


// For serialization
class MatchShadow (match: MatchViewModel) {
    val timestamp = match.timestamp

    val scoutName = match.scoutName.value
    val teamId = match.teamId.value
    val matchId = match.matchId.value
    val alliance = match.alliance.value
    val noShow = match.noShow.value
    val preload = match.preload.value
    val autoMove = match.autoMove.value
    val placedAThing = match.placedAThing.value
    val climbed = match.climbed.value
    val comments = match.comments.value
}