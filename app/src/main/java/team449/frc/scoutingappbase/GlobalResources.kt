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

    var matchSchedule: Map<String, Map<String, List<String>>>? = null
    lateinit var matches: Array<String>
    lateinit var teams: Array<String>

    var dialogTextSize = 0F

    var defaultAlliance = -1

    var event: String? = null

    private var matchSchedulesRaw: MutableMap<String,Map<String,Map<String,List<String>>>>? = null
    var matchSchedules: MutableMap<String,Map<String,Map<String,List<String>>>>?
        get() = matchSchedulesRaw
        set(value) {
            matchSchedulesRaw = value
            matchSchedule = event?.let{ matchSchedules?.get(it) }
            matches = matchSchedule?.keys?.toTypedArray() ?: arrayOf("No match data")
        }

    private var teamListsRaw: Map<String,List<String>>? = null
    var teamLists: Map<String,List<String>>?
        get() = teamListsRaw
        set(value) {
            teamListsRaw = value
            teams = event?.let{teamLists?.get(it)}?.toTypedArray() ?: arrayOf("No team data")
        }

    init {
        matches = arrayOf("No match data")
        teams = arrayOf("No team data")
    }
}
