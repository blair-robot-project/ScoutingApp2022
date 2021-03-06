package team449.frc.refereeappbase.main

import android.content.SharedPreferences
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation.findNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import team449.frc.refereeappbase.R
import team449.frc.refereeappbase._2022.Rung
import team449.frc.refereeappbase.helpers.*
import team449.frc.refereeappbase.managers.BluetoothManager
import team449.frc.refereeappbase.managers.DataManager
import team449.frc.refereeappbase.model.EventData
import team449.frc.refereeappbase.model.MatchShadow
import team449.frc.refereeappbase.model.StaticResources
import team449.frc.refereeappbase.model.makeSyncRequest


interface Editor {
    fun edit(id: String)
}

class MainPresenter(private val activity: MainActivity) : Editor {

    fun globalHelp() {
        help(R.string.help_global)
    }

    fun bluetooth() {
        GlobalScope.launch {
            activity.preferences?.getString("master", null)?.let { BluetoothManager.connect(it) }
        }
    }

    fun edit() {
        editDialog(activity, DataManager.matchNames, this)
    }

    override fun edit(id: String) {
        val mVM = activity.matchViewModel
        DataManager.retrieveMatch(id)?.let { shadow ->
            DataManager.stashCurrent(MatchShadow(mVM))
            mVM.load(shadow, true)
        }
    }

    fun sync() {
        GlobalScope.launch {
            val written = BluetoothManager.write(makeSyncRequest())
            if (!written) {
                activity.preferences?.getString("master", null)?.let {
                    BluetoothManager.connect(it)
                    BluetoothManager.write(makeSyncRequest())
                }
            }
        }
    }

    fun clearData() {
        confirmationDialog(
            activity,
            activity.getString(R.string.clear_data_title),
            activity.getString(R.string.clear_data_body),
            activity.getString(R.string.clear_data_button)
        ) { _, _ -> GlobalScope.launch { DataManager.clear() } }
    }

    fun clearEventData() {
        confirmationDialog(
            activity,
            activity.getString(R.string.clear_event_data_title),
            activity.getString(R.string.clear_event_data_body),
            activity.getString(R.string.clear_event_data_button)
        ) { _, _ ->
            GlobalScope.launch {
                Log.i("-------", "clearing")
                EventData.resetEventData()
                activity.matchViewModel.matchId.postValue(0)
                activity.matchViewModel.teamId.postValue(0)
            }
            clearFile(teamsFile)
            clearFile(matchScheduleFile)
        }
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
        submitMatch(activity, activity.matchViewModel, { postSubmit() }, activity.pageChanger)
    }

    private fun postSubmit() {
        DataManager.recoverMatch()?.let { activity.matchViewModel.load(it, false) }
            ?: activity.matchViewModel.reset()
        activity.moveToPrematch()
    }

    fun help(messageId: Int) {
        info(activity, activity.getString(R.string.help_title), activity.getString(messageId))
    }

    fun matchChanged() {
        activity.matchViewModel.matchId.value?.let { matchId ->
            teamIdForMatchId(matchId)?.let { teamId ->
                activity.matchViewModel.teamId.value = teamId
            }
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
        get() = !(activity.preferences?.getBoolean("lockTeamSpinner", false) ?: false &&
                teamIdForMatchId(
                    activity.matchViewModel.matchId.value ?: 0
                ) == activity.matchViewModel.teamId.value ?: -1)

    val preferencesChanged =
        SharedPreferences.OnSharedPreferenceChangeListener { preferences, key ->
            when (key) {
                "hideNav" -> activity.updateNavBarVisibility()
                "alliance" -> preferences?.getString("alliance", null)?.let {
                    StaticResources.defaultAlliance =
                        if (it == "red") 0 else if (it == "blue") 1 else -1
                    activity.matchViewModel.alliance.value = StaticResources.defaultAlliance
                    matchChanged()
                }
                "driver_station" -> matchChanged()
                "lockTeamSpinner" -> if (preferences.getBoolean(key, false)) {
                    matchChanged()
                }
            }
        }

    /**
     * Increment or decrement a value depending on the view
     */
    fun incrementDecrementValue(view: View) {
        val vm = activity.matchViewModel
        //todo do the same for teleop
        when (view.id) {
            R.id.autoUpperHubInc -> inc(vm.autoUpperHub)
            R.id.autoUpperHubDec -> dec(vm.autoUpperHub)
            R.id.autoLowerHubInc -> inc(vm.autoLowerHub)
            R.id.autoLowerHubDec -> dec(vm.autoLowerHub)
            R.id.teleopUpperHubInc -> inc(vm.teleopUpperHub)
            R.id.teleopUpperHubDec -> dec(vm.teleopUpperHub)
            R.id.teleopLowerHubInc -> inc(vm.teleopLowerHub)
            R.id.teleopLowerHubDec -> dec(vm.teleopLowerHub)
        }
    }

    fun rungSelected(view: View) {
        val vm = activity.matchViewModel
        when (view.id) {
            R.id.radio_traversal -> vm.rung.value = Rung.TRAVERSAL
            R.id.radio_high -> vm.rung.value = Rung.HIGH
            R.id.radio_mid -> vm.rung.value = Rung.MID
            R.id.radio_low -> vm.rung.value = Rung.LOW
            R.id.radio_none -> vm.rung.value = Rung.NONE
        }
    }

    private fun inc(hub: MutableLiveData<Int>) {
        update(hub) { it + 1 }
    }

    private fun dec(hub: MutableLiveData<Int>) {
        update(hub) { n -> if (n > 0) n - 1 else n }
    }

    private fun <T> update(mld: MutableLiveData<T>, fn: (T) -> T) {
        mld.value = mld.value?.let(fn)
    }

    fun onWindowFocusChange() {
        activity.updateNavBarVisibility()
    }

    fun onBackPressed() {
        activity.onSupportNavigateUp()
    }
}