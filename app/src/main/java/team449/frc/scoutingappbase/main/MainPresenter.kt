package team449.frc.scoutingappbase.main

import android.content.SharedPreferences
import android.os.AsyncTask
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation.findNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.helpers.*
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.managers.DataManager
import team449.frc.scoutingappbase.model.EventData
import team449.frc.scoutingappbase.model.StaticResources
import team449.frc.scoutingappbase.model.MatchShadow
import team449.frc.scoutingappbase.model.makeSyncRequest


interface Editor {
    fun edit(id: String)
}

class MainPresenter(private val activity: MainActivity): Editor {

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
            mVM.load(it, true)
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
    fun clearEventData() {
        confirmationDialog(activity, activity.getString(R.string.clear_event_data_title), activity.getString(R.string.clear_event_data_body), activity.getString(R.string.clear_event_data_button))
            {_,_ -> AsyncTask.execute{ DataManager.clearEvent() } }
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
        submitMatch(activity, activity.matchViewModel, Runnable{ postSubmit() }, activity.pageChanger)
    }

    private fun postSubmit() {
        DataManager.recoverMatch()?.let { activity.matchViewModel.load(it, false) } ?: activity.matchViewModel.reset()
        activity.moveToPrematch()
    }

    fun help(messageId: Int) {
        info(activity, activity.getString(R.string.help_title), activity.getString(messageId))
    }

    fun matchChanged() {
        activity.matchViewModel.matchId.value?.let {matchId ->
            teamIdForMatchId(matchId)?.let { teamId ->activity.matchViewModel.teamId.value = teamId }
        }
        activity.fixSpinners()
    }

    private fun teamIdForMatchId(matchId: Int): Int? {
        EventData.matchSchedule?.let { schedule ->
            schedule[EventData.matches.value?.get(matchId)]?.let { alliances ->
                activity.preferences?.let { prefs ->
                    prefs.getString("driver_station", null)?.toInt()?.let { station ->
                        EventData.teams.value?.indexOf(
                            alliances[prefs.getString("alliance", null) ?: ""]?.get(station)
                        )?.let { teamId ->
                            if (teamId >= 0) return teamId
                        }
                    }
                }
            }
        }
        return null
    }

    val teamSpinnerEnabled: Boolean
        get() = !(activity.preferences?.getBoolean("lockTeamSpinner", false)?: false &&
                teamIdForMatchId(activity.matchViewModel.matchId.value?:0) == activity.matchViewModel.teamId.value?:-1)

    val preferencesChanged = SharedPreferences.OnSharedPreferenceChangeListener { preferences, key ->
        when (key) {
            "hideNav" -> activity.updateNavBarVisibility()
            "alliance" -> preferences?.getString("alliance", null)?.let {
                StaticResources.defaultAlliance = if (it == "red") 0 else if (it == "blue") 1 else -1
                activity.matchViewModel.alliance.value = StaticResources.defaultAlliance
                matchChanged()
            }
            "driver_station" -> matchChanged()
            "lockTeamSpinner" -> if (preferences.getBoolean(key, false)) { matchChanged() }
        }
    }

    fun incrementValue(view: View) {
        val vm = activity.matchViewModel
        when (view.id) {
            R.id.ahighInc -> inc(vm.autoHigh)
            R.id.ahighDec -> dec(vm.autoHigh)
            R.id.acenterInc -> inc(vm.autoCenter)
            R.id.acenterDec -> dec(vm.autoCenter)
            R.id.alowInc -> inc(vm.autoLow)
            R.id.alowDec -> dec(vm.autoLow)
            R.id.amissInc -> inc(vm.autoMiss)
            R.id.amissDec -> dec(vm.autoMiss)
            R.id.highInc -> inc(vm.high)
            R.id.highDec -> dec(vm.high)
            R.id.centerInc -> inc(vm.center)
            R.id.centerDec -> dec(vm.center)
            R.id.lowInc -> inc(vm.low)
            R.id.lowDec -> dec(vm.low)
            R.id.missInc -> inc(vm.miss)
            R.id.missDec -> dec(vm.miss)
        }
    }
    private fun inc(mld: MutableLiveData<Int>) {
        mld.value = mld.value?.plus(1)
    }
    private fun dec(mld: MutableLiveData<Int>) {
        mld.value = if ((mld.value?: 0) > 0) mld.value?.plus(-1) else 0
    }

    fun onWindowFocusChange() {
        activity.updateNavBarVisibility()
    }

    fun onBackPressed() {
        activity.onSupportNavigateUp()
    }
}