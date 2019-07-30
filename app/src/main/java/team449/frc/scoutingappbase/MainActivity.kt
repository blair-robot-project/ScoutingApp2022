package team449.frc.scoutingappbase

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import team449.frc.scoutingappbase.helpers.BluetoothHelper
import android.os.AsyncTask


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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_help -> {
            AsyncTask.execute {
                BluetoothHelper.receive()
            }
            true
        }
        R.id.action_bluetooth -> {
            AsyncTask.execute {
                BluetoothHelper.initializeConnection("essuomelpmap")
            }
            true
        }
        R.id.action_settings -> {
            AsyncTask.execute {
                BluetoothHelper.write("hello")
            }
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {}

//    override fun onSupportNavigateUp() =
//        findNavController(R.id.navhost).navigateUp()
}
