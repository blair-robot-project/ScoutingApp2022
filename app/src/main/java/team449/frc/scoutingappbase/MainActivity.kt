package team449.frc.scoutingappbase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import team449.frc.scoutingappbase.databinding.ActivityMainBinding
import team449.frc.scoutingappbase.model.TestViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        navController = findNavController(R.id.navhost)

        val model = ViewModelProviders.of(this).get(TestViewModel::class.java)
        binding.vm = model

        KeyboardHider.setupKeyboard(binding.root, this)
    }

    override fun onSupportNavigateUp() =
        navController.navigateUp()
}
