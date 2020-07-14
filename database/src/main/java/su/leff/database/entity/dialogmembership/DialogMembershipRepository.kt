package su.leff.database.entity.dialogmembership

class DialogMembershipRepository(private val dao: DialogMembershipDAO) {

    suspend fun insertDialog(dialogMembership: DialogMembership) {
        dao.insertDialog(dialogMembership)
    }

    suspend fun fetchAllDialogs(): List<DialogMembership> {
        return dao.fetchAllDialogs()
    }

    suspend fun getDialog(userGUID: String): DialogMembership {
        return dao.getDialog(userGUID)
    }

    suspend fun updateDialog(dialogMembership: DialogMembership) {
        return dao.updateDialog(dialogMembership)
    }

    suspend fun deleteDialog(dialogMembership: DialogMembership) {
        return dao.deleteDialog(dialogMembership)
    }
}