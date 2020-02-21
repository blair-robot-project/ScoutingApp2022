package team449.frc.scoutingappbase

import android.content.res.TypedArray
import java.io.File

// Java can't see things if they aren't lateinit, and matches & teams are needed for Conversions.java
//TODO: Figure out what's actually wrong and find a better solution
@Suppress("UNNECESSARY_LATEINIT")
object GlobalResources {
    lateinit var pages: Array<String>
    lateinit var radioIds: TypedArray
    lateinit var filesDir: File

    private var elimsMatches = arrayOf("Quarters", "Semis", "Finals")
    private var defaultMatches = (1..99).map { it.toString() }.toTypedArray() + elimsMatches
    private var defaultTeams = arrayOf("No team data") + (1..6).map{ "testteam$it" }.toTypedArray()

    var dialogTextSize = 0F

    var defaultAlliance = -1

    var matchSchedule: Map<String, Map<String, List<String>>>? = null
        set(value) {
            field = value
            matches = (value?.keys?.filter{ it.matches("-?\\d+(\\.\\d+)?".toRegex()) }?.sortedBy { it.toInt() }?.toTypedArray()?.plus(elimsMatches))?: defaultMatches
        }
    lateinit var matches: Array<String>
    lateinit var teams: Array<String>

    init {
        matches = defaultMatches
        teams = defaultTeams
    }
}
