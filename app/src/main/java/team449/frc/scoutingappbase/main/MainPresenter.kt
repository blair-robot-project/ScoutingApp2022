package team449.frc.scoutingappbase.main

import android.content.SharedPreferences
import android.os.AsyncTask
import androidx.navigation.Navigation.findNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.StaticResources
import team449.frc.scoutingappbase.helpers.*
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.managers.DataManager
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.makeSyncRequest


interface Editor {
    fun edit(id: String)
}

class MainPresenter(private val activity: MainActivity): Editor {

    var prevMatchId = -1

    fun globalHelp() {
        help(R.string.help_global)
    }

    fun bluetooth() {
        GlobalScope.launch {
            activity.preferences?.getString("master", null)?.let {BluetoothManager.connect(it)}
        }
    }

    fun edit() {
        editDialog(activity, DataManager.matchNames, this)
    }

    override fun edit(id: String) {
        val mVM = activity.matchViewModel
        DataManager.retrieveMatch(id)?.let {
            DataManager.stashCurrent(MatchShadow(mVM))
            mVM.load(it)
        }
    }

    fun sync() {
        GlobalScope.launch {
            BluetoothManager.write(makeSyncRequest())
        }
    }

    fun clearData() {
        confirmationDialog(activity, activity.getString(R.string.clear_data_title), activity.getString(R.string.clear_data_body), activity.getString(R.string.clear_data_button))
            {_,_ -> AsyncTask.execute{ DataManager.clear() } }
    }

    fun settings() {
        findNavController(activity, R.id.navhost).let { navController ->
            if (navController.currentDestination?.id != R.id.settingsFragment) {
                hideSoftKeyboard(activity)
                navController.navigate(R.id.action_mainContainerFragment_to_settingsFragment)
            }
        }
    }

    fun submit() {
        submitMatch(activity.matchViewModel, Runnable{ postSubmit() })
    }

    private fun postSubmit() {
        DataManager.recoverMatch()?.let { activity.matchViewModel.load(it) } ?: activity.matchViewModel.reset()
        activity.moveToPrematch()
    }

    fun help(messageId: Int) {
        info(activity, activity.getString(R.string.help_title), activity.getString(messageId))
    }

    fun matchChanged(matchId: Int) {
        //TODO: This doesn't work if it was reselected but not changed. Think about forcing team, unless schedule can't find it or force_team setting is overridden
        if (matchId != prevMatchId) {
            prevMatchId = matchId
            StaticResources.matchSchedule?.let { schedule ->
                schedule[StaticResources.matches[matchId]]?.let { alliances ->
                    activity.preferences?.let { prefs ->
                        prefs.getString("driver_station", null)?.toInt()?.let { station ->
                            StaticResources.teams.indexOf(
                                alliances[prefs.getString("alliance", null) ?: ""]?.get(station)
                            ).let { teamId ->
                                if (teamId >= 0) activity.matchViewModel.teamId.value = teamId
                            }
                        }
                    }
                }
            }
        }
    }

    val preferencesChanged = SharedPreferences.OnSharedPreferenceChangeListener { preferences, key ->
        when (key) {
            "hideNav" -> activity.updateNavBarVisibility()
            "alliance" -> preferences?.getString("alliance", null)?.let {
                StaticResources.defaultAlliance = if (it == "red") 0 else if (it == "blue") 1 else -1
                activity.matchViewModel.alliance.value = StaticResources.defaultAlliance
                matchChanged(++prevMatchId - 1)
            }
            "driver_sation" -> matchChanged(++prevMatchId - 1)
        }
    }

    fun onWindowFocusChange() {
        activity.updateNavBarVisibility()
    }

    fun onBackPressed() {
        activity.onSupportNavigateUp()
    }
}