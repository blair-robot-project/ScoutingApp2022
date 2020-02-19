package team449.frc.scoutingappbase.main

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.*
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.GlobalResources
import team449.frc.scoutingappbase.fragment.PageChanger
import team449.frc.scoutingappbase.helpers.*
import team449.frc.scoutingappbase.model.MatchViewModel


class MainActivity : AppCompatActivity() {

    private val presenter = MainPresenter(this)

    var pageChanger: PageChanger? = null

    val matchViewModel: MatchViewModel
        get() = ViewModelProviders.of(this).get(MatchViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.appbar))

        setupStaticResources()

        preferences?.registerOnSharedPreferenceChangeListener(presenter.preferencesChanged)

        presenter.bluetooth()

        updateNavBarVisibility()

        val matchObserver = Observer<Int> { matchId ->
            presenter.matchChanged(matchId)
        }
        matchViewModel.matchId.observe(this, matchObserver)
    }

    private fun setupStaticResources() {
        // Hand out resources
        GlobalResources.pages = resources.getStringArray(R.array.pages)
        GlobalResources.radioIds = resources.obtainTypedArray(R.array.radioIds)
        GlobalResources.filesDir = filesDir
        GlobalResources.dialogTextSize = resources.getDimension(R.dimen.alertDialogBodyTextSize)
        preferences?.getString("alliance", null)?.let {
            GlobalResources.defaultAlliance = if (it == "red") 0 else if (it == "blue") 1 else -1
        }
        GlobalResources.event = preferences?.getString("event", null)

        readFromFile(matchScheduleFile)?.let{
            GlobalResources.matchSchedules = deserialize(it)
        }
        readFromFile(teamsFile)?.let{
            GlobalResources.teamLists = deserialize(it)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        presenter.onWindowFocusChange()
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
        R.id.action_help -> {presenter.globalHelp(); true}
        R.id.action_bluetooth -> {presenter.bluetooth(); true}
        R.id.action_edit -> {presenter.edit(); true}
        R.id.action_sync -> {presenter.sync(); true}
        R.id.action_clear_data -> {presenter.clearData(); true}
        R.id.action_settings -> {presenter.settings(); true}
        else -> super.onOptionsItemSelected(item)
    }

    fun help(view: View) {
        Log.i("!!!!!!!!","help")
        when (view.id) {
            R.id.noShowHelp -> Log.i("help","noshow")
        }
    }

    fun fixSpinners() {
        findViewById<Spinner>(R.id.team)?.isEnabled = presenter.teamSpinnerEnabled
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    fun submitButtonPressed() {
        presenter.submit()
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
