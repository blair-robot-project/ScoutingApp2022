package team449.frc.scoutingappbase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import team449.frc.scoutingappbase.databinding.FragmentSecondBinding
import team449.frc.scoutingappbase.databinding.TestFragmentBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private lateinit var viewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        val view: View = binding.root
        binding.lifecycleOwner = this
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val act = activity
        if (act != null) {
            viewModel = ViewModelProviders.of(act).get(TestViewModel::class.java)
        }
        binding.vm = viewModel
    }
}
