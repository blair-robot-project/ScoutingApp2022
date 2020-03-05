package team449.frc.scoutingappbase.helpers

import android.app.Activity
import android.os.AsyncTask
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import team449.frc.scoutingappbase.fragment.PageChanger
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.managers.DataManager
import team449.frc.scoutingappbase.model.*


fun submitMatch(context: Activity, match: MatchViewModel, postSumbit: Runnable, pageChanger: PageChanger?) {
    val ms = MatchShadow(match)
    val hard = validateHard(ms)
    if (hard.errorsp) {
        hardValidationDialog(context, hard.errorString, pageChanger, hard.lowestPage)
    } else {
        val soft = validateSoft(ms)
        if (soft.errorsp) {
            softValidationDialog(context, soft.errorString, pageChanger, soft.lowestPage) { submit(postSumbit, ms) }
        } else {
            submit(postSumbit, ms)
        }
    }
}

private fun validateHard(match: MatchShadow): ValidationError {
    val error = ValidationError()
    if (match.scoutName.isBlank()) error.addError("Please enter your name", 0)
    if (match.noShow) {
        if (arrayOf(match.autoMove, match.hitPartner, match.autoIntake, match.spinnerRot, match.spinnerPos,
                match.park, match.soloClimb==1, match.doubleClimb==1, match.wasLifted).any { it }
            || arrayOf(match.autoHigh, match.autoCenter, match.autoLow, match.autoMiss, match.high, match.center,
                match.low, match.miss, match.attemptedClimb, match.dead, match.defense).any { it > 0 }) {
            error.addError("You have marked some fields true/non-zero, but also say the robot is a no show. These can't both be right.", 0)
        }
    } else {
        if (match.alliance == -1) error.addError("You must select an alliance. This can be done in the setting page, accessible through the gear icon in the top right.", 4)
        if (!match.autoIntake && (match.autoHigh + match.autoCenter + match.autoLow + match.autoMiss) > 3)
            error.addError("The robot cannot have shot more than 3 balls in auto without intaking any balls", 1)
        if (match.attemptedClimb==1 && match.soloClimb==-1 || match.attemptedClimb==2 && (match.doubleClimb==-1 || match.doubleClimb==0 && match.soloClimb==-1))
            error.addError("Please select whether or not the climb was successful", 3)
        if (match.soloClimb==1 || match.doubleClimb==1) {
            if (match.climbTime==0) error.addError("Robots can't climb in 0 seconds.",3)
        } else {
            match.climbTime = 0
        }
    }
    if (!error.errorsp) {
        if (match.attemptedClimb == -1) match.attemptedClimb = 0
        if (match.dead == -1) match.dead = 0
        if (match.defense == -1) match.defense = 0
    }
    return error
}

private fun validateSoft(match: MatchShadow): ValidationError {
    val error = ValidationError()
    if (!match.autoMove) {
        if (match.hitPartner) error.addError("Did the robot really hit its partner in auto without leaving the starting line? If the other robot is the one who ran into this robot, that doesn't count, the field \"Hit partner\" requires this robot to be the one moving.", 1)
        if (match.autoIntake) error.addError("Did the robot really intake balls in auto without leaving the starting line? This could only happen if some balls just happened to roll into the right spot.", 1)
    }
    if (match.spinnerPos) error.addError("Are you sure the robot completed the stage 3 spinner? That seems unlikely at this level of competition. Ask a scouting lead for help if you aren't sure what stage 3 is.", 2)

    if (match.autoHigh + match.autoCenter > 8) error.addError("Are you sure the robot got ${match.autoHigh + match.autoCenter} balls into the high goal during auto? This seems unlikely at this level of competition. Ask a scouting lead for help if you are unsure.", 1)
    if (match.high + match.center > 30) error.addError("Are you sure the robot got ${match.high + match.center} balls into the high goal? This seems unlikely at this level of competition. Ask a scouting lead for help if you are unsure.", 2)
    if (2*match.high < match.center) error.addError("Are you sure the robot is getting more than 2/3 of its high goal shots into the center goal? This seems unlikely at this level of competition. Ask a scouting lead for help if you are unsure.", 2)

    if (match.soloClimb==1 && match.endgameScore < 25 ) error.addError("The endgame score can't have been ${match.endgameScore} if the robot climbed. (Unless a robot trying to park touched this one so the climb didn't count, if so ignore this, the climb still counts here)",3)
    if (match.doubleClimb==1 && match.endgameScore < 50 ) error.addError("The endgame score can't have been ${match.endgameScore} if the robot climbed with a partner. (Unless a robot trying to park touched this one so the climb didn't count, if so ignore this, the climb still counts here)",3)
    if (match.levelCheckbox && !(match.endgameScore in arrayOf(40,45,50,65,70,95) && match.soloClimb==1 || match.endgameScore in arrayOf(65,70,95) && match.doubleClimb==1))
        error.addError("Are you sure the climbing rung was level? If so, the endgame score shouldn't have been ${match.endgameScore}. The one exception is if the rung was level, but climbs didn't count because another robot tried to park under this one and touched it. If that is the case, ignore this message.", 3)
    if (match.climbTime != 0 && match.climbTime < 3) error.addError("Did the robot really climb in ${match.climbTime} seconds from start to finish? That's very fast.", 3)

    return error
}

private fun submit(postSumbit: Runnable, match: MatchShadow) {
    GlobalScope.launch {
        DataManager.submit(match)
        val submitted = BluetoothManager.write(makeMatchDataMessage(match))
        if (!submitted) {
            BluetoothManager.connect()
            BluetoothManager.write(makeSyncRequest())
        }
        Log.i("SubmissionTask", "Match submitted")
    }
    postSumbit.run()
}

