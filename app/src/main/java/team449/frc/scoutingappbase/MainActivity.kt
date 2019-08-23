package team449.frc.scoutingappbase

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import team449.frc.scoutingappbase.helpers.BluetoothHelper
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import team449.frc.scoutingappbase.model.MatchViewModel
import team449.frc.scoutingappbase.model.MessageFactory
import android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import team449.frc.scoutingappbase.helpers.SubmitHelper
import team449.frc.scoutingappbase.model.MatchShadow


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.appbar))

        // Hand out resources
        StaticResources.pages = resources.getStringArray(R.array.pages)
        StaticResources.teams = resources.getStringArray(R.array.teams)
        StaticResources.matches = resources.getStringArray(R.array.matches)
        StaticResources.radioIds = resources.obtainTypedArray(R.array.radioIds)

        hideNav()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        hideNav()
    }

    fun hideNav() {
        window.decorView.systemUiVisibility = (SYSTEM_UI_FLAG_LAYOUT_STABLE
                or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or SYSTEM_UI_FLAG_FULLSCREEN
                or SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_help -> {
//            AsyncTask.execute {
//                BluetoothHelper.receive()
//            }
            DataManager.logSerialized()
            true
        }
        R.id.action_bluetooth -> {
            AsyncTask.execute {
                BluetoothHelper.initializeConnection("essuomelpmap")
            }
            true
        }
        R.id.action_settings -> {
            SubmitHelper.submitMatch(matchViewModel, Runnable { Log.i("mainactivity","submitted data") })
            true
        }
        else -> super.onOptionsItemSelected(item)
    }


    private val matchViewModel: MatchViewModel
        get() = ViewModelProviders.of(this).get(MatchViewModel::class.java)


    override fun onBackPressed() {}

//    override fun onSupportNavigateUp() =
//        findNavController(R.id.navhost).navigateUp()
}
