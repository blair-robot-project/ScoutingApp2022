package team449.frc.scoutingappbase.helpers

import android.app.Activity
import android.os.AsyncTask
import android.util.Log
import team449.frc.scoutingappbase.fragment.PageChanger
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.managers.DataManager
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.MatchViewModel
import team449.frc.scoutingappbase.model.ValidationError
import team449.frc.scoutingappbase.model.makeMatchDataMessage


fun submitMatch(context: Activity, match: MatchViewModel, postSumbit: Runnable, pageChanger: PageChanger?) {
    val ms = MatchShadow(match)
    val hard = validateHard(ms)
    if (hard.errorsp) {
        hardValidationDialog(context, hard.errorString, pageChanger, hard.lowestPage)
    } else {
        val soft = validateSoft(ms)
        if (soft.errorsp) {
            softValidationDialog(context, soft.errorString, pageChanger, soft.lowestPage, SubmissionTask(postSumbit, pageChanger), ms)
        } else {
            SubmissionTask(postSumbit, pageChanger).execute(ms)
        }
    }
}

private fun validateHard(match: MatchShadow): ValidationError {
    val error = ValidationError()
    if (match.scoutName.isBlank()) error.addError("Please enter your name", 0)
    if (match.noShow) {
        if (arrayOf(match.autoMove, match.hitPartner, match.autoIntake, match.spinnerRot, match.spinnerPos,
                match.park, match.soloClimb, match.doubleClimb, match.wasLifted).any { it }
            || arrayOf(match.autoHigh, match.autoCenter, match.autoLow, match.autoMiss, match.high, match.center,
                match.low, match.miss, match.attemptedClimb, match.dead, match.defense).any { it > 0 }) {
            error.addError("You have marked some fields true/non-zero, but also say the robot is a no show. These can't both be right.", 0)
        }
    } else {
        if (match.alliance == -1) error.addError("You must select an alliance. This can be done in the setting page, accessible through the gear icon in the top right.", 4)
        if (!match.autoIntake && (match.autoHigh + match.autoCenter + match.autoLow + match.autoMiss) > 3)
            error.addError("The robot cannot have shot more than 3 balls in auto without intaking any balls", 1)
        if (match.soloClimb || match.doubleClimb) {
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
    if (match.climbTime != 0 && match.climbTime < 3) error.addError("Did the robot really climb in ${match.climbTime} seconds from start to finish? That's very fast.", 3)
    return error
}


class SubmissionTask(private val post: Runnable, pageChanger: PageChanger?): AsyncTask<MatchShadow, Void, Void>() {
    override fun doInBackground(vararg match: MatchShadow): Void? {
        match.first().let {
            DataManager.submit(it)
            BluetoothManager.write(makeMatchDataMessage(it))
            Log.i("SubmissionTask", "Match submitted")
        }
        return null
    }

    override fun onPostExecute(result: Void?) {
        post.run()
    }
}
