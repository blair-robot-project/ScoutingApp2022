package team449.frc.scoutingappbase;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import team449.frc.scoutingappbase.fragment.FragmentOne
import team449.frc.scoutingappbase.fragment.FragmentTwo
import team449.frc.scoutingappbase.fragment.MainContainerFragment

class TestPagerAdapter(fm: FragmentManager, val handler: MainContainerFragment.Handler) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int  = 2

    override fun getItem(i: Int): Fragment {
        return when (i) {
            0 -> FragmentOne()
            1 -> FragmentTwo(handler)
            else -> FragmentOne()
        }
    }
}