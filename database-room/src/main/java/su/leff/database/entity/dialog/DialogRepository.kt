package su.leff.database.entity.dialog

class DialogRepository(private val dao: DialogDAO) {

    suspend fun insertDialog(dialog: DialogEntity) {
        dao.insertDialog(dialog)
    }

    suspend fun fetchAllDialogs(): List<DialogEntity> {
        return dao.fetchAllDialogs()
    }

    suspend fun getDialog(userGUID: String): DialogEntity {
        return dao.getDialog(userGUID)
    }

    suspend fun updateDialog(dialog: DialogEntity) {
        return dao.updateDialog(dialog)
    }

    suspend fun deleteDialog(dialog: DialogEntity) {
        return dao.deleteDialog(dialog)
    }
}