package team449.frc.scoutingappbase;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import team449.frc.scoutingappbase.fragment.PrematchFragment
import team449.frc.scoutingappbase.fragment.AutoFragment
import team449.frc.scoutingappbase.fragment.TeleopFragment

class MatchPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int  = 3

    override fun getItem(i: Int): Fragment =
        when (i) {
            0 -> PrematchFragment()
            1 -> AutoFragment()
            2 -> TeleopFragment()
            else -> PrematchFragment()
        }
}