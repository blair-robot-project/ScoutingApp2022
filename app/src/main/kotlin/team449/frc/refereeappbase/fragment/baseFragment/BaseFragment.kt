package team449.frc.refereeappbase.fragment.baseFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import team449.frc.refereeappbase.helpers.setupKeyboard
import team449.frc.refereeappbase.main.MainActivity

abstract class BaseFragment<B: ViewDataBinding> : Fragment() {

    protected abstract val layoutId: Int

    protected lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner

        val view: View = binding.root

        setupKeyboard(view, activity as MainActivity?)

        return view
    }
}