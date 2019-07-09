package team449.frc.scoutingappbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentPagerAdapter



class MainActivity : AppCompatActivity() {
    lateinit var adapterViewPager: FragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(R.layout.activity_main)
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, TestFragment.newInstance())
//                .commitNow()
//        }
        var vpPager: ViewPager = findViewById(R.id.pager)
		adapterViewPager = testPagerAdapter(getSupportFragmentManager())
		vpPager.adapter = adapterViewPager
    }
}
