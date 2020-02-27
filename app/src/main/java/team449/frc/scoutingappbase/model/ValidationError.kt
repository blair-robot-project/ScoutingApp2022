package team449.frc.scoutingappbase.model

class ValidationError {
    var errorString = ""
        get() = field.trim()
    var lowestPage = 4

    fun addError(string: String, page: Int) {
        errorString += string + "\n"
        if (page < lowestPage) lowestPage = page
    }

    val errorsp: Boolean
        get() = errorString.isNotEmpty()
}