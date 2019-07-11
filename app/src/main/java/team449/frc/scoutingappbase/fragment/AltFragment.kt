package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.databinding.FragmentAltBinding
import team449.frc.scoutingappbase.fragment.baseFragment.BaseFragment

class AltFragment : BaseFragment<FragmentAltBinding>() {
    override val layoutId: Int = R.layout.fragment_alt
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.handler = Handler(findNavController())
    }

    class Handler(navController: NavController) {
        val navController = navController

        fun onClick(view: View) {
            navController.navigate(R.id.action_altFragment_to_mainContainerFragment)
        }
    }
}