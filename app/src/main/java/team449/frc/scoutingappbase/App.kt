package team449.frc.scoutingappbase

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        // Hand out resources
        StaticResources.pages = resources.getStringArray(R.array.pages)
        StaticResources.teams = resources.getStringArray(R.array.teams)
        StaticResources.matches = resources.getStringArray(R.array.matches)
        StaticResources.radioIds = resources.obtainTypedArray(R.array.radioIds)
    }
}