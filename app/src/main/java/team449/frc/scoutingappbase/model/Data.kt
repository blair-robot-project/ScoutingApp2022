package team449.frc.scoutingappbase.model

import java.util.*

data class Data(val submitted: MutableMap<Long, MutableList<MatchShadow>>, val partial: Stack<MatchShadow>)