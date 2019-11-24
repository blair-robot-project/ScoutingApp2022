package team449.frc.scoutingappbase.helpers

import android.os.AsyncTask
import android.util.Log
import team449.frc.scoutingappbase.managers.DataManager
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.MatchViewModel
import team449.frc.scoutingappbase.model.makeMatchDataMessage


fun submitMatch(match: MatchViewModel, postSumbit: Runnable) {
    SubmissionTask(match, postSumbit).execute()
}

private fun validateHard(match: MatchShadow): Boolean {
    //TODO: Data validation
    return true
}


class SubmissionTask(val match: MatchViewModel, val post: Runnable): AsyncTask<Void, Void, Boolean>() {
    override fun doInBackground(vararg params: Void?): Boolean {
        val matchShadow = MatchShadow(match)
        if (validateHard(matchShadow)) {
            DataManager.submit(matchShadow)
            val message = makeMatchDataMessage(matchShadow)
            BluetoothManager.write(message)
            Log.i("SubmissionTask", "Match submitted")
            return true
        } else {
            Log.i("SubmissionTask","Hard validation failed")
        }
        return false
    }

    override fun onPostExecute(result: Boolean?) {
        if (result != null && result) {
            match.reset()
            post.run()
        }
    }
}
