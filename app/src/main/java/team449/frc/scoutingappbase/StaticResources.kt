package team449.frc.scoutingappbase

import android.content.res.TypedArray
import java.io.File

object StaticResources {
    lateinit var pages: Array<String>
    lateinit var teams: Array<String>
    lateinit var matches: Array<String>
    lateinit var radioIds: TypedArray
    lateinit var filesDir: File

    var matchSchedule: Map<String,Map<String,List<String>>>? = null

    var dialogTextSize = 0F

    var defaultAlliance = -1
}