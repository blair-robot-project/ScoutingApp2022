package team449.frc.refereeappbase.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * The total number of crates per alliance
 */
const val NUM_CRATES = 20

fun <T : Any?> mutableLiveData(initialValue: T) =
    MutableLiveData<T>().apply { value = initialValue }

class MatchViewModel : ViewModel() {
    var timestamp = System.currentTimeMillis()
    var revision = 0

    val recorderName by lazy { mutableLiveData("") }
    val matchId by lazy { mutableLiveData(0) }
    val teamId by lazy { mutableLiveData(0) }
    val alliance by lazy { mutableLiveData(StaticResources.defaultAlliance) }
    val noShow by lazy { mutableLiveData(false) }
    /** The 2 points for moving out of the starting zone in auto */
    val taxi by lazy { mutableLiveData(false) }
    val reachedAlliance by lazy { mutableLiveData(false) }
    val endgameScore by lazy { mutableLiveData(0) }
    val dead by lazy { mutableLiveData(-1) }
    val incursions by lazy { mutableLiveData(0) }
    val defense by lazy { mutableLiveData(-1) }
    val comments by lazy { mutableLiveData("") }

    fun reset() {
        timestamp = System.currentTimeMillis()
        revision = 0

        //Pre-match
        // If numeric add one, otherwise it's playoffs so don't increment
        matchId.value = matchId.value?.plus(
            if (EventData.matches.value?.get(matchId.value as Int)
                    ?.matches(Regex("\\d+(?:\\.\\d+)?")) == true
            ) 1 else 0
        )
        teamId.value = 0
        noShow.value = false

        //Auto
        taxi.value = false

        //Teleop

        //Endgame
        reachedAlliance.value = false
        endgameScore.value = 0

        dead.value = -1
        incursions.value = 0
        defense.value = -1
        comments.value = ""
    }

    fun load(shadow: MatchShadow, edit: Boolean) {
        timestamp = shadow.timestamp
        revision = shadow.revision + if (edit) 1 else 0

        recorderName.value = shadow.recorderName
        matchId.value = shadow.matchId
        teamId.value = shadow.teamId
        alliance.value = shadow.alliance
        noShow.value = shadow.noShow

        //Auto
        taxi.value = shadow.taxi

        //Teleop

        //Endgame
        reachedAlliance.value = shadow.reachedAlliance
        endgameScore.value = shadow.endgameScore

        dead.value = shadow.dead
        incursions.value = shadow.incursions
        defense.value = shadow.defense
        comments.value = shadow.comments
    }
}

// For serialization
class MatchShadow(matchViewModel: MatchViewModel) {
    val timestamp = matchViewModel.timestamp
    val revision = matchViewModel.revision

    val recorderName = matchViewModel.recorderName.value ?: ""
    val matchId = matchViewModel.matchId.value
    val teamId = matchViewModel.teamId.value
    val alliance = matchViewModel.alliance.value ?: -1
    val noShow = matchViewModel.noShow.value ?: false

    //Auto
    val taxi = matchViewModel.taxi.value ?: false

    //Teleop

    //Endgame
    var reachedAlliance = matchViewModel.reachedAlliance.value ?: false
    val endgameScore =
        StaticResources.endgameScoreOptions[matchViewModel.endgameScore.value ?: 0].toInt()

    var dead = matchViewModel.dead.value ?: -1
    val incursions = matchViewModel.incursions.value ?: 0
    var defense = matchViewModel.defense.value ?: -1
    val comments = matchViewModel.comments.value ?: ""

    val match: String = matchId?.let { EventData.matches.value?.get(it) } ?: ""
    val team: String = teamId?.let { EventData.teams.value?.get(it) } ?: ""
}