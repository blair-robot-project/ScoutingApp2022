package team449.frc.refereeappbase.fragment

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import team449.frc.refereeappbase.R
import team449.frc.refereeappbase.main.MainActivity
import team449.frc.refereeappbase.managers.BluetoothManager


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