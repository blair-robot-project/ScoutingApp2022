package team449.frc.scoutingappbase.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

fun <T: Any?> mutableLiveData(initialValue: T) = MutableLiveData<T>().apply { postValue(initialValue) }

class MatchViewModel : ViewModel() {
    var timestamp = System.currentTimeMillis()
    var revision = 0

    // Prematch
    val scoutName by lazy { mutableLiveData("") }
    val teamId by lazy { mutableLiveData(0) }
    val matchId by lazy { mutableLiveData(0) }
    val alliance by lazy { mutableLiveData(-1) }
    val noShow by lazy { mutableLiveData(false) }
    val preload by lazy { mutableLiveData(-1) }
    // Auto
    val autoMove by lazy { mutableLiveData(false) }
    // Teleop
    val placedAThing by lazy { mutableLiveData(false) }
    // Endgame
    val climbed by lazy { mutableLiveData(false) }
    // General
    val comments by lazy { mutableLiveData("") }


    fun reset() {
        timestamp = System.currentTimeMillis()
        revision = 0

        // Prematch
        teamId.value = 0
        matchId.value = matchId.value?.plus(1)
        noShow.value = false
        preload.value = -1
        // Auto
        autoMove.value = false
        // Teleop
        placedAThing.value = false
        // Endgame
        climbed.value = false
        // General
        comments.value = ""
    }
}


// For serialization
class MatchShadow (match: MatchViewModel) {
    val timestamp = match.timestamp
    val revision = match.revision

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