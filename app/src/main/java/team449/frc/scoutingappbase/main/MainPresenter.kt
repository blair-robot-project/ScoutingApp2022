package team449.frc.scoutingappbase.main

import android.os.AsyncTask
import android.util.Log
import androidx.navigation.Navigation.findNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.adapters.MatchPagerAdapter
import team449.frc.scoutingappbase.helpers.info
import team449.frc.scoutingappbase.helpers.submitMatch
import team449.frc.scoutingappbase.managers.BluetoothManager

class MainPresenter(private val mainActivity: MainActivity) {

    fun globalHelp() {
        help(R.string.help_global)
    }

    fun bluetooth() {
        GlobalScope.launch {
            BluetoothManager.connect("essuomelpmap")
        }
    }

    fun sync() {
        GlobalScope.launch {
            BluetoothManager.receive()
        }
    }

    fun settings() {
        findNavController(mainActivity, R.id.navhost).navigate(R.id.action_mainContainerFragment_to_altFragment)
    }

    fun submit() {
        submitMatch(mainActivity.matchViewModel, Runnable { mainActivity.moveToPrematch() })
    }

    fun help(messageId: Int) {
        info(mainActivity, mainActivity.getString(R.string.help_title), mainActivity.getString(messageId))
    }

    fun onWindowFocusChange() {
        mainActivity.hideNav()
    }

    fun onBackPressed() {}
}