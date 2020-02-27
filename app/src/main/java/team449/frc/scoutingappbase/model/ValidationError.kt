package team449.frc.scoutingappbase.model

class ValidationError {
    private var errorStringRaw = ""
    val errorString
        get() = errorStringRaw.trim()
    var lowestPage = 4

    fun addError(string: String, page: Int) {
        errorStringRaw += string + "\n"
        if (page < lowestPage) lowestPage = page
    }

    val errorsp: Boolean
        get() = errorString.isNotEmpty()
}