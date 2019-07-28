package team449.frc.scoutingappbase.fragment

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

class GeneralFragment: VMBaseFragment<FragmentGeneralBinding>() {
    override val layoutId: Int = R.layout.fragment_general
}