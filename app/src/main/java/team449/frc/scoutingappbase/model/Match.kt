package team449.frc.scoutingappbase.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

fun <T: Any?> mutableLiveData(initialValue: T) = MutableLiveData<T>().apply { postValue(initialValue) }

class MatchViewModel : ViewModel() {
    var timestamp = System.currentTimeMillis()
    var revision = 0

    val scoutName by lazy { mutableLiveData("") }
    val matchId by lazy { mutableLiveData(0) }
    val teamId by lazy { mutableLiveData(0) }
    val alliance by lazy { mutableLiveData(GlobalResources.defaultAlliance) }
    val noShow by lazy { mutableLiveData(false) }
    val autoMove by lazy { mutableLiveData(false) }
    val hitPartner by lazy { mutableLiveData(false) }
    val autoIntake by lazy { mutableLiveData(false) }
    val autoHigh by lazy { mutableLiveData(0) }
    val autoCenter by lazy { mutableLiveData(0) }
    val autoLow by lazy { mutableLiveData(0) }
    val autoMiss by lazy { mutableLiveData(0) }
    val high by lazy { mutableLiveData(0) }
    val center by lazy { mutableLiveData(0) }
    val low by lazy { mutableLiveData(0) }
    val miss by lazy { mutableLiveData(0) }
    val spinnerRot by lazy { mutableLiveData(false) }
    val spinnerPos by lazy { mutableLiveData(false) }
    val attemptedClimb by lazy { mutableLiveData(-1) }
    val park by lazy { mutableLiveData(false) }
    val soloClimb by lazy { mutableLiveData(false) }
    val doubleClimb by lazy { mutableLiveData(false) }
    val wasLifted by lazy { mutableLiveData(false) }
    val climbTime by lazy { mutableLiveData(0) }
    val dead by lazy { mutableLiveData(-1) }
    val defense by lazy { mutableLiveData(-1) }
    val comments by lazy { mutableLiveData("") }

    fun reset() {
        timestamp = System.currentTimeMillis()
        revision = 0

        // If numeric add one, otherwise it's playoffs so don't increment
        matchId.value = matchId.value?.plus(if (GlobalResources.matches[matchId.value as Int].matches(Regex("\\d+(?:\\.\\d+)?"))) 1 else 0)
        teamId.value = 0
        noShow.value = false
        autoMove.value = false
        comments.value = ""
    }

    fun load(shadow: MatchShadow) {
        timestamp = shadow.timestamp
        revision = shadow.revision + 1

        scoutName.value = shadow.scoutName
        matchId.value = shadow.matchId
        teamId.value = shadow.teamId
        alliance.value = shadow.alliance
        noShow.value = shadow.noShow
        autoMove.value = shadow.autoMove
        comments.value = shadow.comments
    }
}


// For serialization
class MatchShadow (matchViewModel: MatchViewModel) {
    val timestamp = matchViewModel.timestamp
    val revision = matchViewModel.revision

    val scoutName = matchViewModel.scoutName.value
    val matchId = matchViewModel.matchId.value
    val teamId = matchViewModel.teamId.value
    val alliance = matchViewModel.alliance.value
    val noShow = matchViewModel.noShow.value
    val autoMove = matchViewModel.autoMove.value
    val comments = matchViewModel.comments.value

    val match: String = matchId?.let{ GlobalResources.matches[it]} ?:""
    val team: String = teamId?.let{ GlobalResources.teams[it]} ?:""
}