package su.leff.core.data

class Dialog(
    val dialogGUID: String,
    val name: String,
    val isGroup: Boolean
) {

    companion object {
        val EMPTY = Dialog("", "", false)
    }
}