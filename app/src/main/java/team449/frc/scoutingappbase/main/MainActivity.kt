package team449.frc.scoutingappbase.main

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.StaticResources
import team449.frc.scoutingappbase.fragment.PageChanger
import team449.frc.scoutingappbase.model.MatchViewModel


class MainActivity : AppCompatActivity() {

    private val mainPresenter = MainPresenter(this)

    var pageChanger: PageChanger? = null

    val matchViewModel: MatchViewModel
        get() = ViewModelProviders.of(this).get(MatchViewModel::class.java)


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
        preferences?.getString("position", null)?.get(0)?.let {
            StaticResources.defaultAlliance = if (it == 'R') 0 else if (it == 'B') 1 else -1
        }

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(mainPresenter.preferencesChanged)

        updateNavBarVisibility()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        mainPresenter.onWindowFocusChange()
    }

    val preferences: SharedPreferences?
        get() = PreferenceManager.getDefaultSharedPreferences(this)

    fun updateNavBarVisibility() {
        preferences?.getBoolean("hideNav", false)?.let {
            if (it) {
                window.decorView.systemUiVisibility = (SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or SYSTEM_UI_FLAG_FULLSCREEN
                        or SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            } else {
                window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_VISIBLE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_help -> {mainPresenter.globalHelp(); true}
        R.id.action_bluetooth -> {mainPresenter.bluetooth(); true}
        R.id.action_edit -> {mainPresenter.edit(); true}
        R.id.action_sync -> {mainPresenter.sync(); true}
        R.id.action_clear_data -> {mainPresenter.clearData(); true}
        R.id.action_settings -> {mainPresenter.settings(); true}
        else -> super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        mainPresenter.onBackPressed()
    }

    fun submitButtonPressed() {
        Log.i("MainActivity","submitButtonPressed")
        mainPresenter.submit()
    }

    fun moveToPrematch() {
        pageChanger?.changePage(0)
    }

    override fun onSupportNavigateUp() = findNavController(this, R.id.navhost).navigateUp()

    fun showUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
}
