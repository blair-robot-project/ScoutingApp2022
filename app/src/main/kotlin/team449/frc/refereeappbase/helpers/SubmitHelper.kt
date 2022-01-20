package team449.frc.refereeappbase.helpers

import android.app.Activity
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import team449.frc.refereeappbase.fragment.PageChanger
import team449.frc.refereeappbase.managers.BluetoothManager
import team449.frc.refereeappbase.managers.DataManager
import team449.frc.refereeappbase.model.*


fun submitMatch(
    context: Activity,
    match: MatchViewModel,
    postSumbit: Runnable,
    pageChanger: PageChanger?
) {
    val ms = MatchShadow(match)
    val hard = validateHard(ms)
    if (hard.errorsp) {
        hardValidationDialog(context, hard.errorString, pageChanger, hard.lowestPage)
    } else {
        val soft = validateSoft(ms)
        if (soft.errorsp) {
            softValidationDialog(context, soft.errorString, pageChanger, soft.lowestPage) {
                submit(
                    postSumbit,
                    ms
                )
            }
        } else {
            submit(postSumbit, ms)
        }
    }
}

//TODO add Bunnybot-specific stuff to this
private fun validateHard(match: MatchShadow): ValidationError {
    val error = ValidationError()
    if (match.recorderName.isBlank()) error.addError("Please enter your name", 0)
    if (match.noShow) {
        if (arrayOf(match.taxi).any { it }
            || arrayOf(match.dead, match.defense).any { it > 0 }) {
            error.addError(
                "You have marked some fields true/non-zero, but also say the robot is a no show. These can't both be right.",
                0
            )
        }
    } else {
        if (match.alliance == -1) error.addError(
            "You must select an alliance. This can be done in the setting page, accessible through the gear icon in the top right.",
            4
        )

    }
    if (!error.errorsp) {
        if (match.dead == -1) match.dead = 0
        if (match.defense == -1) match.defense = 0
    }
    return error
}

//TODO write bunnybot-specific stuff for this
private fun validateSoft(match: MatchShadow): ValidationError {
    val error = ValidationError()

    return error
}

private fun submit(postSubmit: Runnable, match: MatchShadow) {
    GlobalScope.launch {
        DataManager.submit(match)
        val submitted = BluetoothManager.write(makeMatchDataMessage(match))
        if (!submitted) {
            BluetoothManager.connect()
            BluetoothManager.write(makeSyncRequest())
        }
        Log.i("SubmissionTask", "Match submitted")
    }
    postSubmit.run()
}

