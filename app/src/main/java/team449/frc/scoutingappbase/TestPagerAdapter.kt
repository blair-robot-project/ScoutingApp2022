package team449.frc.scoutingappbase;

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import team449.frc.scoutingappbase.fragment.FragmentOne
import team449.frc.scoutingappbase.fragment.FragmentTwo
import team449.frc.scoutingappbase.fragment.baseFragment.VMBaseFragment
import kotlin.reflect.KClass

class TestPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int  = 2

    private val frags: Array<KClass<out VMBaseFragment<out ViewDataBinding>>> =
        arrayOf(FragmentOne::class, FragmentTwo::class)

    override fun getItem(i: Int): Fragment = frags[i].constructors.first().call()
}