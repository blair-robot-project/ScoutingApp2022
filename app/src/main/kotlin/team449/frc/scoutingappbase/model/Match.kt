package team449.frc.scoutingappbase.model

import android.view.View
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.main.MainActivity
import java.lang.RuntimeException

fun <T : Any?> mutableLiveData(initialValue: T) =
    MutableLiveData<T>().apply { value = initialValue }

/**
 * Find the id of the bunny button in the corresponding zone given the zone's quadrant
 */
fun zoneToBunnyId(quadrant: Int) = when (quadrant) {
    1 -> R.id.zone1Bunny
    2 -> R.id.zone2Bunny
    3 -> R.id.zone3Bunny
    4 -> R.id.zone4Bunny
    else -> throw RuntimeException("Quadrant $quadrant was not in range [1, 4]")
}

/**
 * Find the quadrant of the zone a bunny button is in, given that button's id
 */
fun bunnyIdToZone(bunnyId: Int) = when (bunnyId) {
    R.id.zone1Bunny -> 1
    R.id.zone2Bunny -> 2
    R.id.zone3Bunny -> 3
    R.id.zone4Bunny -> 4
    else -> throw RuntimeException("Cannot convert id $bunnyId to quadrant, not a bunny")
}

class MatchViewModel : ViewModel() {
    var timestamp = System.currentTimeMillis()
    var revision = 0

    val scoutName by lazy { mutableLiveData("") }
    val matchId by lazy { mutableLiveData(0) }
    val teamId by lazy { mutableLiveData(0) }
    val alliance by lazy { mutableLiveData(StaticResources.defaultAlliance) }
    val noShow by lazy { mutableLiveData(false) }
    val autoMove by lazy { mutableLiveData(false) }
    val zone1Crates by lazy { mutableLiveData(0) }
    val zone2Crates by lazy { mutableLiveData(0) }
    val zone3Crates by lazy { mutableLiveData(0) }
    val zone4Crates by lazy { mutableLiveData(0) }
    /** The zone in which the bunny was placed. If the bunny has not been placed yet, the value is -1. */
    val bunnyZone by lazy { mutableLiveData(-1) }
    val reachedAlliance by lazy { mutableLiveData(false) }
    val endgameScore by lazy { mutableLiveData(0) }
    val dead by lazy { mutableLiveData(-1) }
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

        zone1Crates.value = 0
        zone2Crates.value = 0
        zone3Crates.value = 0
        zone4Crates.value = 0
        bunnyZone.value = -1

        //Auto
        autoMove.value = false

        //Teleop

        //Endgame
        reachedAlliance.value = false
        endgameScore.value = 0

        dead.value = -1
        defense.value = -1
        comments.value = ""
    }

    fun load(shadow: MatchShadow, edit: Boolean) {
        timestamp = shadow.timestamp
        revision = shadow.revision + if (edit) 1 else 0

        scoutName.value = shadow.scoutName
        matchId.value = shadow.matchId
        teamId.value = shadow.teamId
        alliance.value = shadow.alliance
        noShow.value = shadow.noShow

        zone1Crates.value = shadow.zone1Crates
        zone2Crates.value = shadow.zone2Crates
        zone3Crates.value = shadow.zone3Crates
        zone4Crates.value = shadow.zone4Crates
        bunnyZone.value = shadow.bunnyZone

        //Auto
        autoMove.value = shadow.autoMove

        //Teleop

        //Endgame
        reachedAlliance.value = shadow.reachedAlliance
        endgameScore.value = shadow.endgameScore

        dead.value = shadow.dead
        defense.value = shadow.defense
        comments.value = shadow.comments
    }

    fun bunnyDrawableFor(view: View) =
        if (bunnyZone.value == view.id) view.setBackgroundResource(R.drawable.ic_pink_bunny)
        else view.setBackgroundResource(R.drawable.ic_grey_bunny)
}

// For serialization
class MatchShadow(matchViewModel: MatchViewModel) {
    val timestamp = matchViewModel.timestamp
    val revision = matchViewModel.revision

    val scoutName = matchViewModel.scoutName.value ?: ""
    val matchId = matchViewModel.matchId.value
    val teamId = matchViewModel.teamId.value
    val alliance = matchViewModel.alliance.value ?: -1
    val noShow = matchViewModel.noShow.value ?: false

    val zone1Crates = matchViewModel.zone1Crates.value ?: 0
    val zone2Crates = matchViewModel.zone1Crates.value ?: 0
    val zone3Crates = matchViewModel.zone1Crates.value ?: 0
    val zone4Crates = matchViewModel.zone1Crates.value ?: 0
    val bunnyZone = matchViewModel.bunnyZone.value ?: -1

    //Auto
    val autoMove = matchViewModel.autoMove.value ?: false

    //Teleop

    //Endgame
    var reachedAlliance = matchViewModel.reachedAlliance.value ?: false
    val endgameScore =
        StaticResources.endgameScoreOptions[matchViewModel.endgameScore.value ?: 0].toInt()

    var dead = matchViewModel.dead.value ?: -1
    var defense = matchViewModel.defense.value ?: -1
    val comments = matchViewModel.comments.value ?: ""

    val match: String = matchId?.let { EventData.matches.value?.get(it) } ?: ""
    val team: String = teamId?.let { EventData.teams.value?.get(it) } ?: ""
}