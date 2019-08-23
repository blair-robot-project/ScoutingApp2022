package team449.frc.scoutingappbase.helpers

import android.os.AsyncTask
import team449.frc.scoutingappbase.DataManager
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.MatchViewModel
import team449.frc.scoutingappbase.model.MessageFactory

object SubmitHelper {
    fun submitMatch(match: MatchViewModel, postSumbit: Runnable) {
        val matchShadow = MatchShadow(match)
        DataManager.submit(matchShadow)
        AsyncTask.execute {
            submitBluetoothThread(matchShadow, postSumbit)
        }
        match.reset()
    }

    private fun submitBluetoothThread(matchShadow: MatchShadow, postSumbit: Runnable) {
        if (validateHard(matchShadow)) {
            val message = MessageFactory.makeMatchDataMessage(matchShadow)
            BluetoothHelper.write(message)
            postSumbit.run()
        }
    }

    fun validateHard(match: MatchShadow): Boolean {
        //TODO: Data validation
        return true
    }
}