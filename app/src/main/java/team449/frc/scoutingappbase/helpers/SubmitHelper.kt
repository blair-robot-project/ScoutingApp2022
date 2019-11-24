package team449.frc.scoutingappbase.helpers

import android.os.AsyncTask
import android.util.Log
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.managers.DataManager
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.MatchViewModel
import team449.frc.scoutingappbase.model.makeMatchDataMessage


fun submitMatch(match: MatchViewModel, postSumbit: Runnable) {
    SubmissionTask(postSumbit).execute(MatchShadow(match))
}

private fun validateHard(match: MatchShadow): Boolean {
    //TODO: Data validation
    return true
}


class SubmissionTask(private val post: Runnable): AsyncTask<MatchShadow, Void, Boolean>() {
    override fun doInBackground(vararg match: MatchShadow): Boolean {
        match.first().let {
            if (validateHard(it)) {
                DataManager.submit(it)
                BluetoothManager.write(makeMatchDataMessage(it))
                Log.i("SubmissionTask", "Match submitted")
                return true
            } else {
                Log.i("SubmissionTask","Hard validation failed")
            }
        }
        return false
    }

    override fun onPostExecute(result: Boolean) {
        if (result) post.run()
    }
}
