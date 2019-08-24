package team449.frc.scoutingappbase.main

import android.os.AsyncTask
import android.util.Log
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.helpers.info
import team449.frc.scoutingappbase.helpers.submitMatch
import team449.frc.scoutingappbase.managers.BluetoothManager

class MainPresenter(private val mainActivity: MainActivity) {

    fun globalHelp() {
        help(R.string.help_global)
    }

    fun bluetooth() {
        AsyncTask.execute {
            BluetoothManager.initializeConnection("essuomelpmap")
        }
    }

    fun settings() {
        submitMatch(mainActivity.matchViewModel, Runnable { Log.i("mainactivity","submitted data") })
    }

    fun help(messageId: Int) {
        info(mainActivity, mainActivity.getString(R.string.help_title), mainActivity.getString(messageId))
    }

    fun onWindowFocusChange(){
        mainActivity.hideNav()
    }

    fun onBackPressed() {}
}