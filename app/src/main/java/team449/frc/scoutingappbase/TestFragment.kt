package team449.frc.scoutingappbase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

class TestFragment : Fragment() {

    private lateinit var pagerAdapter: testPagerAdapter
    private lateinit var viewPager: ViewPager

    companion object {
        fun newInstance() = TestFragment()
    }

    private lateinit var viewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.test_fragment, container, false)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
//        // TODO: Use the ViewModel
//    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        pagerAdapter = testPagerAdapter(childFragmentManager)
//        viewPager = view.findViewById(R.id.pager)
//        viewPager.adapter = pagerAdapter
//    }
}
