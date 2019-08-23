package team449.frc.scoutingappbase.helpers

import android.os.AsyncTask
import team449.frc.scoutingappbase.managers.DataManager
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.MatchViewModel
import team449.frc.scoutingappbase.model.makeMatchDataMessage


fun submitMatch(match: MatchViewModel, postSumbit: Runnable) {
    val matchShadow = MatchShadow(match)
    DataManager.submit(matchShadow)
    AsyncTask.execute {
        submitBluetoothThread(matchShadow, postSumbit)
    }
    match.reset()
}

private fun validateHard(match: MatchShadow): Boolean {
    //TODO: Data validation
    return true
}

private fun submitBluetoothThread(matchShadow: MatchShadow, postSumbit: Runnable) {
    if (validateHard(matchShadow)) {
        val message = makeMatchDataMessage(matchShadow)
        BluetoothManager.write(message)
        postSumbit.run()
    }
}
