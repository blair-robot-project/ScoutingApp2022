package team449.frc.refereeappbase.model

import java.io.File

object StaticResources {
    lateinit var pages: Array<String>
    lateinit var filesDir: File

    var dialogTextSize = 0F

    lateinit var endgameScoreOptions: Array<String>

    var defaultAlliance = -1

    lateinit var radioIdsDead: List<Int>
    lateinit var radioIdsDefense: List<Int>
    lateinit var radioIdsClimb: List<Int>
    lateinit var radioIdsDoubleClimb: List<Int>
    lateinit var radioIdsSoloClimb: List<Int>
}
