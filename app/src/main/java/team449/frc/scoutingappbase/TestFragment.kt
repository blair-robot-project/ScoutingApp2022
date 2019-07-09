package team449.frc.scoutingappbase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import team449.frc.scoutingappbase.databinding.TestFragmentBinding

class TestFragment : Fragment() {

    private lateinit var pagerAdapter: testPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var binding: TestFragmentBinding

    companion object {
        fun newInstance() = TestFragment()
    }

    private lateinit var viewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.test_fragment, container, false)
        val view: View = binding.root
        binding.lifecycleOwner = this
        return view
//        return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val act = activity
        if (act != null) {
            viewModel = ViewModelProviders.of(act).get(TestViewModel::class.java)
        }
        binding.vm = viewModel
        // TODO: Use the ViewModel
    }

}
