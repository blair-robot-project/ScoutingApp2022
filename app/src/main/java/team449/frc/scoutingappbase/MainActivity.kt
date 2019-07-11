package team449.frc.scoutingappbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentFactory
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import team449.frc.scoutingappbase.databinding.ActivityMainBinding
import team449.frc.scoutingappbase.fragment.MainContainerFragment


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        navController = findNavController(R.id.navhost)

        val model = ViewModelProviders.of(this).get(TestViewModel::class.java)
        binding.vm = model

    }

    override fun onSupportNavigateUp() =
        navController.navigateUp()
}
