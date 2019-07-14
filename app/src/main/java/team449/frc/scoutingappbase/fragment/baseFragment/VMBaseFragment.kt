package team449.frc.scoutingappbase.fragment.baseFragment

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import team449.frc.scoutingappbase.BR
import team449.frc.scoutingappbase.model.TestViewModel


abstract class VMBaseFragment<B: ViewDataBinding> : BaseFragment<B>() {

    protected lateinit var viewModel: TestViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val act = activity
        if (act != null) {
            viewModel = ViewModelProviders.of(act).get(TestViewModel::class.java)
        }
        binding.setVariable(BR.vm,viewModel)
    }
}