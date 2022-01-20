package team449.frc.refereeappbase.fragment

import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.databinding.ViewDataBinding
import team449.frc.refereeappbase.BR
import team449.frc.refereeappbase.R
import team449.frc.refereeappbase.databinding.*
import team449.frc.refereeappbase.fragment.baseFragment.VMBaseFragment
import team449.frc.refereeappbase.main.MainActivity
import team449.frc.refereeappbase.model.EventData

/**
 * A fragment where a field is displayed
 */
sealed class FieldFragment<T : ViewDataBinding> : VMBaseFragment<T>() {
    private fun updateField() {
        val vm = (activity as MainActivity).matchViewModel
        //todo update for 2022
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

class PenaltyFragment : VMBaseFragment<FragmentPenaltyBinding>() {
    override val layoutId: Int = R.layout.fragment_penalty
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