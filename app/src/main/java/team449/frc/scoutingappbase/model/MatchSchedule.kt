package team449.frc.scoutingappbase.model

data class MatchSchedule(val matches: Map<String, MatchScheduleMatch>)

data class MatchScheduleMatch(val red: Array<String>, val blue: Array<String>)