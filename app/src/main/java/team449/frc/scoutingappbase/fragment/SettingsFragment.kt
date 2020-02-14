package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.GlobalResources
import team449.frc.scoutingappbase.main.MainActivity
import team449.frc.scoutingappbase.managers.BluetoothManager


class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val masterList: ListPreference? = findPreference("master")
        masterList?.let{setMasterPreferenceData(it)}

        val eventList: ListPreference? = findPreference("event")
        eventList?.let{setEventPreferenceData(it)}
    }

    private fun setMasterPreferenceData(lp: ListPreference) {
        BluetoothManager.pairedDevices.toTypedArray().let {entries ->
            //TODO: Check what happens when it is empty
            if (entries.isNotEmpty()) {
                lp.entries = entries
                lp.entryValues = entries
            }
        }
    }

    private fun setEventPreferenceData(lp: ListPreference) {
        GlobalResources.matchSchedules?.keys?.let { events ->
            if (events.isNotEmpty()) {
                lp.entries = events.toTypedArray()
                lp.entryValues = events.toTypedArray()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showUpButton()
    }
}