package team449.frc.scoutingappbase

import android.content.res.TypedArray
import team449.frc.scoutingappbase.model.MatchSchedule
import java.io.File

object StaticResources {
    lateinit var pages: Array<String>
    lateinit var teams: Array<String>
    lateinit var matches: Array<String>
    lateinit var radioIds: TypedArray
    lateinit var filesDir: File

    lateinit var matchSchedule: Map<String,Map<String,Array<String>>> //MatchSchedule

    var dialogTextSize = 0F

    var defaultAlliance = -1
}