package team449.frc.scoutingappbase.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import team449.frc.scoutingappbase.fragment.*

class MatchPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int  = 5

    override fun getItem(i: Int): Fragment =
        when (i) {
            0 -> PrematchFragment()
            1 -> AutoFragment()
            2 -> TeleopFragment()
            3 -> EndgameFragment()
            4 -> GeneralFragment()
            else -> PrematchFragment()
        }
}