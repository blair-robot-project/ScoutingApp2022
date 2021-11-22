package team449.frc.scoutingappbase.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import team449.frc.scoutingappbase.fragment.*

class MatchPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> PrematchFragment()
            1 -> AutoFragment()
            2 -> TeleopFragment()
            3 -> EndgameFragment()
            4 -> GeneralFragment()
            else -> PrematchFragment()
        }
}