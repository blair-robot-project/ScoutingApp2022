package team449.frc.refereeappbase.fragment.baseFragment

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import team449.frc.refereeappbase.BR
import team449.frc.refereeappbase.model.MatchViewModel


abstract class VMBaseFragment<B : ViewDataBinding> : BaseFragment<B>() {

    protected lateinit var viewModel: MatchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { viewModel = ViewModelProvider(it)[MatchViewModel::class.java] }
        binding.setVariable(BR.vm, viewModel)
    }
}