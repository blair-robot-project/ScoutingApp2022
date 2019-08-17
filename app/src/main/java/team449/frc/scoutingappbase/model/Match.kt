package team449.frc.scoutingappbase.model

import androidx.lifecycle.MutableLiveData

fun <T: Any?> mutableLiveData(initialValue: T) = MutableLiveData<T>().apply { postValue(initialValue) }

class Match {
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
}

// Removes MutableLiveData
class MatchShadow (match: Match) {
    var scoutName: String? = ""
    var teamId: Int? = 0
    var matchId: Int? = 0
    var alliance: Int? = 0
    var noShow: Boolean? = false
    var preload: Int? = 0
    var autoMove: Boolean? = false
    var placedAThing: Boolean? = false
    var climbed: Boolean? = false
    var comments: String? = ""

    init {
        scoutName = match.scoutName.value
        teamId = match.teamId.value
        matchId = match.matchId.value
        alliance = match.alliance.value
        noShow = match.noShow.value
        preload = match.preload.value
        autoMove = match.autoMove.value
        placedAThing = match.placedAThing.value
        climbed = match.climbed.value
        comments = match.comments.value
    }
}