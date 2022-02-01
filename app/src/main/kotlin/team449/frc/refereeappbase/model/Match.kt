package team449.frc.refereeappbase.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import team449.frc.refereeappbase._2022.Rung

/**
 * The total number of crates per alliance
 */

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

    //Auto
    val autoLowerHub by lazy { mutableLiveData(0) }
    val autoUpperHub by lazy { mutableLiveData(0) }

    /** The 2 points for moving out of the starting zone in auto */
    val taxi by lazy { mutableLiveData(false) }

    //Teleop
    val teleopLowerHub by lazy { mutableLiveData(0) }
    val teleopUpperHub by lazy { mutableLiveData(0) }

    //Endgame
    val rung by lazy { mutableLiveData(Rung.NONE) }

    //Submission
    val dead by lazy { mutableLiveData(-1) }
    val incursions by lazy { mutableLiveData(0) }
    val defense by lazy { mutableLiveData(-1) }
    val comments by lazy { mutableLiveData("") }

    fun reset() {
        timestamp = System.currentTimeMillis()
        revision = 0

        //Pre-match
        // If numeric add one, otherwise it's playoffs so don't increment
        val numericRegex = Regex("\\d+(?:\\.\\d+)?")
        if (EventData.matches.value?.get(matchId.value as Int)?.matches(numericRegex) == true) {
            matchId.value?.let { it + 1 }
        }
        teamId.value = 0
        noShow.value = false

        //Auto
        autoLowerHub.value = 0
        autoUpperHub.value = 0
        taxi.value = false

        //Teleop
        teleopLowerHub.value = 0
        teleopUpperHub.value = 0

        //Endgame
        rung.value = Rung.NONE

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
        autoLowerHub.value = shadow.autoLowerHub
        autoUpperHub.value = shadow.autoUpperHub
        taxi.value = shadow.taxi

        //Teleop
        teleopLowerHub.value = shadow.teleopLowerHub
        teleopUpperHub.value = shadow.teleopUpperHub

        //Endgame
        rung.value = shadow.rung

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
    val autoLowerHub = matchViewModel.autoLowerHub.value ?: 0
    val autoUpperHub = matchViewModel.autoUpperHub.value ?: 0
    val taxi = matchViewModel.taxi.value ?: false

    //Teleop
    val teleopLowerHub = matchViewModel.teleopLowerHub.value ?: 0
    val teleopUpperHub = matchViewModel.teleopUpperHub.value ?: 0

    //Endgame
    val rung = matchViewModel.rung.value ?: Rung.NONE

    var dead = matchViewModel.dead.value ?: -1
    val incursions = matchViewModel.incursions.value ?: 0
    var defense = matchViewModel.defense.value ?: -1
    val comments = matchViewModel.comments.value ?: ""

    val match: String = matchId?.let { EventData.matches.value?.get(it) } ?: ""
    val team: String = teamId?.let { EventData.teams.value?.get(it) } ?: ""
}