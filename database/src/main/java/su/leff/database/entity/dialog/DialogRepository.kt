package su.leff.database.entity.dialog

class DialogRepository(private val dao: DialogDAO) {

    suspend fun insertDialog(dialog: Dialog) {
        dao.insertDialog(dialog)
    }

    suspend fun fetchAllDialogs(): List<Dialog> {
        return dao.fetchAllDialogs()
    }

    suspend fun getDialog(userGUID: String): Dialog {
        return dao.getDialog(userGUID)
    }

    suspend fun updateDialog(dialog: Dialog) {
        return dao.updateDialog(dialog)
    }

    suspend fun deleteDialog(dialog: Dialog) {
        return dao.deleteDialog(dialog)
    }
}