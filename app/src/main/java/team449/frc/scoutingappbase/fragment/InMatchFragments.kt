package team449.frc.scoutingappbase.fragment

import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.databinding.FragmentAutoBinding
import team449.frc.scoutingappbase.databinding.FragmentPrematchBinding
import team449.frc.scoutingappbase.databinding.FragmentTeleopBinding
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