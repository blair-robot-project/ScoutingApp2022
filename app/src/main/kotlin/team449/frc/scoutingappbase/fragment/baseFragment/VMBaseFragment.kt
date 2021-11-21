package team449.frc.scoutingappbase.fragment.baseFragment

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import team449.frc.scoutingappbase.BR
import team449.frc.scoutingappbase.model.MatchViewModel


abstract class VMBaseFragment<B: ViewDataBinding> : BaseFragment<B>() {

    protected lateinit var viewModel: MatchViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val act = activity
        if (act != null)
            viewModel = ViewModelProvider(act)[MatchViewModel::class.java]
        binding.setVariable(BR.vm, viewModel)
    }
}