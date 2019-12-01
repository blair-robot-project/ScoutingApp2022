package team449.frc.scoutingappbase.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import team449.frc.scoutingappbase.StaticResources

fun <T: Any?> mutableLiveData(initialValue: T) = MutableLiveData<T>().apply { postValue(initialValue) }

class MatchViewModel : ViewModel() {
    var timestamp = System.currentTimeMillis()
    var revision = 0

    val scoutName by lazy { mutableLiveData("") }
    val matchId by lazy { mutableLiveData(0) }
    val teamId by lazy { mutableLiveData(0) }
    val alliance by lazy { mutableLiveData(StaticResources.defaultAlliance) }
    val noShow by lazy { mutableLiveData(false) }
    val preload by lazy { mutableLiveData(-1) }
    val autoMove by lazy { mutableLiveData(false) }
    val placedAThing by lazy { mutableLiveData(false) }
    val climbed by lazy { mutableLiveData(false) }
    val comments by lazy { mutableLiveData("") }

    fun reset() {
        timestamp = System.currentTimeMillis()
        revision = 0

        // If numeric add one, otherwise it's playoffs so don't increment
        matchId.value = matchId.value?.plus(if (StaticResources.matches[matchId.value as Int].matches(Regex("\\d+(?:\\.\\d+)?"))) 1 else 0)
        teamId.value = 0
        noShow.value = false
        preload.value = -1
        autoMove.value = false
        placedAThing.value = false
        climbed.value = false
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
        preload.value = shadow.preload
        autoMove.value = shadow.autoMove
        placedAThing.value = shadow.placedAThing
        climbed.value = shadow.climbed
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
    val preload = matchViewModel.preload.value
    val autoMove = matchViewModel.autoMove.value
    val placedAThing = matchViewModel.placedAThing.value
    val climbed = matchViewModel.climbed.value
    val comments = matchViewModel.comments.value

    val match: String = matchId?.let{StaticResources.matches[it]} ?:""
    val team: String = teamId?.let{StaticResources.teams[it]} ?:""
}