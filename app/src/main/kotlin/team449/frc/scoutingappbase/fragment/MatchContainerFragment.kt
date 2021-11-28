package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.adapters.MatchPagerAdapter
import team449.frc.scoutingappbase.databinding.FragmentMatchContainerBinding
import team449.frc.scoutingappbase.fragment.baseFragment.VMBaseFragment
import team449.frc.scoutingappbase.main.MainActivity
import team449.frc.scoutingappbase.model.selectBunny
import team449.frc.scoutingappbase.model.zoneToBunnyId
import kotlin.math.max
import kotlin.math.min

interface MatchContainerFragmentClickHandler {
    fun next(view: View)
    fun prev(view: View)
}

interface PageChanger {
    fun changePage(page: Int)
}

class MatchContainerFragment : VMBaseFragment<FragmentMatchContainerBinding>(),
    MatchContainerFragmentClickHandler, PageChanger {
    override val layoutId: Int = R.layout.fragment_match_container

    private lateinit var viewPagerAdapter: FragmentStateAdapter
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)

        val mainActivity = activity as MainActivity
        mainActivity.pageChanger = this
        binding.handler = this

        viewPagerAdapter = MatchPagerAdapter(mainActivity)
        viewPager.adapter = viewPagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.page = position
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })

        val tabLayout = view.findViewById<TabLayout>(R.id.pageDots)
        TabLayoutMediator(tabLayout, viewPager) { tab, _position ->
            tab.text = ""
        }.attach()
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).hideUpButton()
    }

    override fun changePage(page: Int) {
        viewPager.currentItem = page
    }

    override fun next(view: View) {
        changePage(min(viewPager.currentItem + 1, (viewPager.adapter?.itemCount ?: 1) - 1))
    }

    override fun prev(view: View) {
        changePage(max(viewPager.currentItem - 1, 0))
    }
}
