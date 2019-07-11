package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.TestPagerAdapter
import team449.frc.scoutingappbase.databinding.FragmentMainContainerBinding
import team449.frc.scoutingappbase.fragment.baseFragment.VMBaseFragment


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

    }

    class Handler(val navController: NavController, val viewPager: ViewPager) {

        fun home(view: View) {
            viewPager.setCurrentItem(0)
        }

        fun next(view: View) {
            navController.navigate(R.id.action_mainContainerFragment_to_altFragment)
        }
    }
}
