package team449.frc.scoutingappbase.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
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

        hideNav()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        mainPresenter.onWindowFocusChange()
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
        R.id.action_help -> {mainPresenter.globalHelp(); true}
        R.id.action_bluetooth -> {mainPresenter.bluetooth(); true}
        R.id.action_sync -> {mainPresenter.sync(); true}
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

//    override fun onSupportNavigateUp() =
//        findNavController(R.id.navhost).navigateUp()
}
