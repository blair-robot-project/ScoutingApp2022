package team449.frc.refereeappbase.model

import java.util.*

data class Data(val submitted: MutableMap<String, MutableList<MatchShadow>>, val partial: Stack<MatchShadow>)