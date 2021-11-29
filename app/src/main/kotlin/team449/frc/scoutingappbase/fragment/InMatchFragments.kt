package team449.frc.scoutingappbase.fragment

import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.databinding.ViewDataBinding
import team449.frc.scoutingappbase.BR
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.databinding.*
import team449.frc.scoutingappbase.fragment.baseFragment.VMBaseFragment
import team449.frc.scoutingappbase.helpers.bunnyIds
import team449.frc.scoutingappbase.helpers.selectBunny
import team449.frc.scoutingappbase.helpers.unselectBunny
import team449.frc.scoutingappbase.helpers.zoneToBunnyId
import team449.frc.scoutingappbase.main.MainActivity
import team449.frc.scoutingappbase.model.EventData

/**
 * A fragment where a field is displayed
 */
sealed class FieldFragment<T : ViewDataBinding> : VMBaseFragment<T>() {
    private fun updateField() {
        val vm = (activity as MainActivity).matchViewModel
        val bunnyZone = vm.bunnyZone.value
        if (bunnyZone != null && bunnyZone != -1) {
            view?.findViewById<View?>(zoneToBunnyId(bunnyZone))?.let { selectBunny(it, vm) }
        } else {
            //Deselect all the bunnies because the bunny isn't in any zone
            for (bunnyId in bunnyIds)
                view?.findViewById<View?>(bunnyId)?.let { unselectBunny(it, vm) }
        }
    }

    override fun onStart() {
        super.onStart()
        updateField()
    }

    override fun onResume() {
        super.onResume()
        updateField()
    }
}

class PrematchFragment : VMBaseFragment<FragmentPrematchBinding>() {
    override val layoutId: Int = R.layout.fragment_prematch

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.setVariable(BR.eventData, EventData)
    }

    override fun onStart() {
        super.onStart()
        activity?.findViewById<Spinner>(R.id.match)
            ?.setSelection(Conversions.unbox(viewModel.matchId.value))
        activity?.findViewById<Spinner>(R.id.team)
            ?.setSelection(Conversions.unbox(viewModel.teamId.value))
        (activity as MainActivity?)?.fixSpinners()
    }
}

class AutoFragment : FieldFragment<FragmentAutoBinding>() {
    override val layoutId: Int = R.layout.fragment_auto
}

class TeleopFragment : FieldFragment<FragmentTeleopBinding>() {
    override val layoutId: Int = R.layout.fragment_teleop
}

class EndgameFragment : FieldFragment<FragmentEndgameBinding>() {
    override val layoutId: Int = R.layout.fragment_endgame
}

interface SubmitHandler {
    fun submit(view: View)
}

class GeneralFragment : VMBaseFragment<FragmentGeneralBinding>(), SubmitHandler {
    override val layoutId: Int = R.layout.fragment_general

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.handler = this
    }

    override fun submit(view: View) {
        (activity as MainActivity).submitButtonPressed()
    }
}