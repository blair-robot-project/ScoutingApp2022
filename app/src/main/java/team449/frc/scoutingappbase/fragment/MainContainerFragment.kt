package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.TestPagerAdapter
import team449.frc.scoutingappbase.databinding.FragmentMainContainerBinding
import team449.frc.scoutingappbase.fragment.baseFragment.VMBaseFragment
import kotlin.math.max
import kotlin.math.min


class MainContainerFragment : VMBaseFragment<FragmentMainContainerBinding>() {
    private lateinit var adapterViewPager: FragmentPagerAdapter
    override val layoutId: Int = R.layout.fragment_main_container

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vpPager: ViewPager = view.findViewById(R.id.pager)

        val handler = Handler(findNavController(), vpPager)
        binding.handler = handler

        adapterViewPager = TestPagerAdapter(childFragmentManager, handler)
        vpPager.adapter = adapterViewPager

        val tabLayout = view.findViewById<TabLayout>(R.id.pageDots)
        tabLayout.setupWithViewPager(vpPager, true)

    }

    class Handler(val navController: NavController, val viewPager: ViewPager) {

        fun next(view: View) {
            viewPager.currentItem = min(viewPager.currentItem + 1, viewPager.childCount)
        }
        fun prev(view: View) {
            viewPager.currentItem = max(viewPager.currentItem - 1, 0)
        }

        fun other(view: View) {
            navController.navigate(R.id.action_mainContainerFragment_to_altFragment)
        }
    }
}
