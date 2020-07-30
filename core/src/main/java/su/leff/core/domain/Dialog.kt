package su.leff.core.domain

class Dialog(
    val dialogGUID: String,
    val name: String,
    val isGroup: Boolean
) {

    companion object {
        val EMPTY = Dialog("", "", false)
    }
}