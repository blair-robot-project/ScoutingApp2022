package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.tabs.TabLayout
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.TestPagerAdapter
import team449.frc.scoutingappbase.databinding.FragmentMainContainerBinding
import team449.frc.scoutingappbase.fragment.baseFragment.VMBaseFragment
import kotlin.math.max
import kotlin.math.min


class MainContainerFragment : VMBaseFragment<FragmentMainContainerBinding>() {
    override val layoutId: Int = R.layout.fragment_main_container

    private lateinit var viewPagerAdapter: FragmentPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)

        binding.handler = Handler(this)

        viewPagerAdapter = TestPagerAdapter(childFragmentManager)
        viewPager.adapter = viewPagerAdapter
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) { binding.page = position }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
        })

        val tabLayout = view.findViewById<TabLayout>(R.id.pageDots)
        tabLayout.setupWithViewPager(viewPager, true)
    }

    private fun changePage(page: Int) { viewPager.currentItem = page }
    fun next() = changePage(min(viewPager.currentItem + 1, (viewPager.adapter?.count ?: 1) - 1))
    fun prev() = changePage(max(viewPager.currentItem - 1, 0))
    fun other() = findNavController().navigate(R.id.action_mainContainerFragment_to_altFragment)

    @Suppress("UNUSED_PARAMETER")
    class Handler(private val frag: MainContainerFragment) {
        fun next(view: View) = frag.next()
        fun prev(view: View) = frag.prev()
        fun other(view: View) = frag.other()
    }
}
