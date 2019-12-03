package team449.frc.scoutingappbase.model

import java.util.*

data class Data(val submitted: MutableMap<String, MutableList<MatchShadow>>, val partial: Stack<MatchShadow>)