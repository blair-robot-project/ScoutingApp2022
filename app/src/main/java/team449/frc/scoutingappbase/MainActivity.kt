package team449.frc.scoutingappbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import team449.frc.scoutingappbase.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var adapterViewPager: FragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, TestFragment.newInstance())
//                .commitNow()
//        }

        binding.lifecycleOwner = this


        val model = ViewModelProviders.of(this).get(TestViewModel::class.java)
        binding.vm = model

        val vpPager: ViewPager = findViewById(R.id.pager)
		adapterViewPager = testPagerAdapter(getSupportFragmentManager())
		vpPager.adapter = adapterViewPager
    }
}
