package team449.frc.scoutingappbase

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import team449.frc.scoutingappbase.helpers.info
import team449.frc.scoutingappbase.managers.BluetoothManager
import team449.frc.scoutingappbase.helpers.submitMatch
import team449.frc.scoutingappbase.managers.DataManager
import team449.frc.scoutingappbase.model.MatchViewModel


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
        StaticResources.filesDir = filesDir
        StaticResources.dialogTextSize = resources.getDimension(R.dimen.alertDialogBodyTextSize)

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
//                BluetoothManager.receive()
//            }
            DataManager.logSerialized()
            DataManager.load()
            DataManager.logSerialized()
            true
        }
        R.id.action_bluetooth -> {
            info(this,"Title","body")
            AsyncTask.execute {
                BluetoothManager.initializeConnection("essuomelpmap")
            }
            true
        }
        R.id.action_settings -> {
            submitMatch(matchViewModel, Runnable { Log.i("mainactivity","submitted data") })
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
