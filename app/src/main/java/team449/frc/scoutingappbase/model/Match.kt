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
        hitPartner.value = false
        autoIntake.value = false
        autoHigh.value = 0
        autoCenter.value = 0
        autoLow.value = 0
        autoMiss.value = 0

        high.value = 0
        center.value = 0
        low.value = 0
        miss.value = 0
        spinnerRot.value = false
        spinnerPos.value = false

        attemptedClimb.value = -1
        park.value = false
        soloClimb.value = false
        doubleClimb.value = false
        wasLifted.value = false
        climbTime.value = 0

        dead.value = -1
        defense.value = -1
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
        hitPartner.value = shadow.hitPartner
        autoIntake.value = shadow.autoIntake
        autoHigh.value = shadow.autoHigh
        autoCenter.value = shadow.autoCenter
        autoLow.value = shadow.autoLow
        autoMiss.value = shadow.autoMiss

        high.value = shadow.high
        center.value = shadow.center
        low.value = shadow.low
        miss.value = shadow.miss
        spinnerRot.value = shadow.spinnerRot
        spinnerPos.value = shadow.spinnerPos

        attemptedClimb.value = shadow.attemptedClimb
        park.value = shadow.park
        soloClimb.value = shadow.soloClimb
        doubleClimb.value = shadow.doubleClimb
        wasLifted.value = shadow.wasLifted
        climbTime.value = shadow.climbTime

        dead.value = shadow.dead
        defense.value = shadow.defense
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
    val hitPartner = matchViewModel.hitPartner.value
    val autoIntake = matchViewModel.autoIntake.value
    val autoHigh = matchViewModel.autoHigh.value
    val autoCenter = matchViewModel.autoCenter.value
    val autoLow = matchViewModel.autoLow.value
    val autoMiss = matchViewModel.autoMiss.value
    
    val high = matchViewModel.high.value
    val center = matchViewModel.center.value
    val low = matchViewModel.low.value
    val miss = matchViewModel.miss.value
    val spinnerRot = matchViewModel.spinnerRot.value
    val spinnerPos = matchViewModel.spinnerPos.value
     
    val attemptedClimb = matchViewModel.attemptedClimb.value
    val park = matchViewModel.park.value
    val soloClimb = matchViewModel.soloClimb.value
    val doubleClimb = matchViewModel.doubleClimb.value
    val wasLifted = matchViewModel.wasLifted.value
    val climbTime = matchViewModel.climbTime.value
     
    val dead = matchViewModel.dead.value
    val defense = matchViewModel.defense.value
    val comments = matchViewModel.comments.value

    val match: String = matchId?.let{ GlobalResources.matches[it] } ?:""
    val team: String = teamId?.let{ GlobalResources.teams[it] } ?:""

    private val Boolean?.int
        get() = if (this==true) 1 else 0
    val soloClimbNYF = if (attemptedClimb==1 || attemptedClimb==2 && doubleClimb==false && soloClimb==true) 2 - soloClimb.int else 0
    val doubleClimbNYF = if (attemptedClimb==2) 2 - doubleClimb.int else 0
    val wasLiftedNYF = if (attemptedClimb==3) 2 - wasLifted.int else 0
}