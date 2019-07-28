package team449.frc.scoutingappbase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hand out resources
        StaticResources.pages = resources.getStringArray(R.array.pages)
        StaticResources.teams = resources.getStringArray(R.array.teams)
        StaticResources.matches = resources.getStringArray(R.array.matches)
        StaticResources.radioIds = resources.obtainTypedArray(R.array.radioIds)
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.navhost).navigateUp()
}
