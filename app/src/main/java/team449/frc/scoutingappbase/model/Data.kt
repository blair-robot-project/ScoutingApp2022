package team449.frc.scoutingappbase.model

data class Data(val submitted: MutableMap<Long, MutableMap<Int, MatchShadow>>, val partial: List<MatchShadow>)