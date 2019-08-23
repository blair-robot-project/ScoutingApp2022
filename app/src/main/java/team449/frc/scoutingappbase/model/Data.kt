package team449.frc.scoutingappbase.model

data class Data(val submitted: MutableMap<String, MutableMap<String, MatchShadow>>, val partial: List<MatchShadow>)