package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.main.MainActivity


class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showUpButton()
    }
}