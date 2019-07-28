package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.databinding.*
import team449.frc.scoutingappbase.fragment.baseFragment.VMBaseFragment

class PrematchFragment: VMBaseFragment<FragmentPrematchBinding>() {
    override val layoutId: Int = R.layout.fragment_prematch
}

class AutoFragment: VMBaseFragment<FragmentAutoBinding>() {
    override val layoutId: Int = R.layout.fragment_auto
}

class TeleopFragment: VMBaseFragment<FragmentTeleopBinding>() {
    override val layoutId: Int = R.layout.fragment_teleop
}

class EndgameFragment: VMBaseFragment<FragmentEndgameBinding>() {
    override val layoutId: Int = R.layout.fragment_endgame
}

interface SubmitHandler { fun submit(view: View) }

class GeneralFragment: VMBaseFragment<FragmentGeneralBinding>(), SubmitHandler {
    override val layoutId: Int = R.layout.fragment_general

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.handler = this
    }

    override fun submit(view: View) { findNavController().navigate(R.id.action_mainContainerFragment_to_altFragment) }
}