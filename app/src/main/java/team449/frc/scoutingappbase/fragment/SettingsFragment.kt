package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.main.MainActivity
import team449.frc.scoutingappbase.managers.BluetoothManager


class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val masterList: ListPreference? = findPreference("master")
        masterList?.let{setMasterPreferenceData(it)}
    }

    private fun setMasterPreferenceData(lp: ListPreference) {
        BluetoothManager.pairedDevices.toTypedArray().let {entries ->
            if (entries.isNotEmpty()) {
                lp.entries = entries
                lp.entryValues = entries
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showUpButton()
    }
}