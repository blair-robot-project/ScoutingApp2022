package team449.frc.scoutingappbase.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

fun <T: Any?> mutableLiveData(initialValue: T) = MutableLiveData<T>().apply { value = initialValue }

class MatchViewModel : ViewModel() {
    var timestamp = System.currentTimeMillis()
    var revision = 0

    val scoutName by lazy { mutableLiveData("") }
    val matchId by lazy { mutableLiveData(0) }
    val teamId by lazy { mutableLiveData(0) }
    val alliance by lazy { mutableLiveData(StaticResources.defaultAlliance) }
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
    val spinnerRot by lazy { mutableLiveData(false)  }
    val spinnerPos by lazy { mutableLiveData(false)  }
    val attemptedClimb by lazy { mutableLiveData(-1) }
    val park by lazy { mutableLiveData(false) }
    val soloClimb by lazy { mutableLiveData(false) }
    val doubleClimb by lazy { mutableLiveData(false) }
    val wasLifted by lazy { mutableLiveData(false) }
    val climbTime by lazy { mutableLiveData( 0) }
    val dead by lazy { mutableLiveData(-1) }
    val defense by lazy { mutableLiveData(-1) }
    val comments by lazy { mutableLiveData("") }

    fun reset() {
        timestamp = System.currentTimeMillis()
        revision = 0

        // If numeric add one, otherwise it's playoffs so don't increment
        matchId.value = matchId.value?.plus(if (EventData.matches[matchId.value as Int].matches(Regex("\\d+(?:\\.\\d+)?"))) 1 else 0)
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

    fun load(shadow: MatchShadow, edit: Boolean) {
        timestamp = shadow.timestamp
        revision = shadow.revision + if (edit) 1 else 0

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

    val scoutName = matchViewModel.scoutName.value?:""
    val matchId = matchViewModel.matchId.value
    val teamId = matchViewModel.teamId.value
    val alliance = matchViewModel.alliance.value?:-1
    val noShow = matchViewModel.noShow.value?: false
    
    val autoMove = matchViewModel.autoMove.value?: false
    val hitPartner = matchViewModel.hitPartner.value?: false
    val autoIntake = matchViewModel.autoIntake.value?: false
    val autoHigh = matchViewModel.autoHigh.value?: 0
    val autoCenter = matchViewModel.autoCenter.value?: 0
    val autoLow = matchViewModel.autoLow.value?: 0
    val autoMiss = matchViewModel.autoMiss.value?: 0
    
    val high = matchViewModel.high.value?: 0
    val center = matchViewModel.center.value?: 0
    val low = matchViewModel.low.value?: 0
    val miss = matchViewModel.miss.value?: 0
    val spinnerRot = matchViewModel.spinnerRot.value?: false
    val spinnerPos = matchViewModel.spinnerPos.value?: false
     
    var attemptedClimb = matchViewModel.attemptedClimb.value?: 0
    val doubleClimb = matchViewModel.doubleClimb.value?: false && attemptedClimb==2
    val soloClimb = matchViewModel.soloClimb.value?: false && (attemptedClimb==1 || attemptedClimb==2 && !doubleClimb)
    val wasLifted = matchViewModel.wasLifted.value?: false && attemptedClimb==3
    val park = if (soloClimb || doubleClimb || wasLifted) false else matchViewModel.park.value?: false
    var climbTime = matchViewModel.climbTime.value?: 0
     
    var dead = matchViewModel.dead.value?: -1
    var defense = matchViewModel.defense.value?: -1
    val comments = matchViewModel.comments.value?: ""

    val match: String = matchId?.let{ EventData.matches[it] } ?:""
    val team: String = teamId?.let{ EventData.teams[it] } ?:""

    private val Boolean?.int
        get() = if (this==true) 1 else 0
    val soloClimbNYF = if (attemptedClimb==1 || attemptedClimb==2 && !doubleClimb && soloClimb) 2 - soloClimb.int else 0
    val doubleClimbNYF = if (attemptedClimb==2) 2 - doubleClimb.int else 0
    val wasLiftedNYF = if (attemptedClimb==3) 2 - wasLifted.int else 0
}