package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import android.view.View
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.databinding.FragmentTwoBinding
import team449.frc.scoutingappbase.fragment.baseFragment.VMBaseFragment

class FragmentTwo(val handler: MainContainerFragment.Handler): VMBaseFragment<FragmentTwoBinding>() {
    override val layoutId: Int = R.layout.fragment_two
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.handler = handler
    }
}