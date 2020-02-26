package team449.frc.scoutingappbase.main

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
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
import team449.frc.scoutingappbase.fragment.PageChanger
import team449.frc.scoutingappbase.helpers.deserialize
import team449.frc.scoutingappbase.helpers.matchScheduleFile
import team449.frc.scoutingappbase.helpers.readFromFile
import team449.frc.scoutingappbase.helpers.teamsFile
import team449.frc.scoutingappbase.model.GlobalResources
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

        val matchObserver = Observer<Int> { _ -> presenter.matchChanged() }
        matchViewModel.matchId.observe(this, matchObserver)
    }

    private fun setupStaticResources() {
        // Hand out resources
        GlobalResources.pages = resources.getStringArray(R.array.pages)
        GlobalResources.filesDir = filesDir
        GlobalResources.dialogTextSize = resources.getDimension(R.dimen.alertDialogBodyTextSize)

        var ri = resources.obtainTypedArray(R.array.radioIdsDead)
        GlobalResources.radioIdsDead = (0..ri.length()).map { ri.getResourceId(it, 0) }
        ri.recycle()
        ri = resources.obtainTypedArray(R.array.radioIdsDefense)
        GlobalResources.radioIdsDefense = (0..ri.length()).map { ri.getResourceId(it, 0) }
        ri.recycle()
        ri = resources.obtainTypedArray(R.array.radioIdsClimb)
        GlobalResources.radioIdsClimb = (0..ri.length()).map { ri.getResourceId(it, 0) }
        ri.recycle()

        preferences?.getString("alliance", null)?.let {
            GlobalResources.defaultAlliance = if (it == "red") 0 else if (it == "blue") 1 else -1
        }

        readFromFile(matchScheduleFile)?.let{
            GlobalResources.matchSchedule = deserialize(it)
        }
        readFromFile(teamsFile)?.let{
            GlobalResources.teams = (deserialize(it) as List<String>).toTypedArray()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        presenter.onWindowFocusChange()
    }

    // TODO: deal with this and all the other stuff that just got deprecated in API29
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
        when (view.id) {
            R.id.noShowHelp -> presenter.help(R.string.help_noshow)
            R.id.autoMoveHelp -> presenter.help(R.string.help_initiation)
            R.id.hitPartnerHelp -> presenter.help(R.string.help_hitpartner)
            R.id.autoIntakeHelp -> presenter.help(R.string.help_autointake)
            R.id.spinnerRotationHelp -> presenter.help(R.string.help_spinnertwo)
            R.id.spinnerPositionHelp -> presenter.help(R.string.help_spinnerthree)
            R.id.attemptedClimbHelp -> presenter.help(R.string.help_attemptedclimb)
            R.id.soloHelp -> presenter.help(R.string.help_doublefailsolo)
            R.id.parkedHelp -> presenter.help(R.string.help_parked)
            R.id.climbTimeHelp -> presenter.help(R.string.help_climbtime)
            R.id.deadHelp -> presenter.help(R.string.help_dead)
            R.id.defenseHelp -> presenter.help(R.string.help_defense)
        }
    }

    fun incrementValue(view: View) {
        presenter.incrementValue(view)
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
