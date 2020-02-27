package team449.frc.scoutingappbase.model

import java.io.File

object StaticResources {
    lateinit var pages: Array<String>
    lateinit var filesDir: File

    var dialogTextSize = 0F

    var defaultAlliance = -1

    lateinit var radioIdsDead: List<Int>
    lateinit var radioIdsDefense: List<Int>
    lateinit var radioIdsClimb: List<Int>
}
