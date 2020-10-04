package su.leff.database.entity.dialogmembership

class DialogMembershipEntityRepository(private val dao: DialogMembershipEntityDAO) {

    suspend fun insertDialog(dialogMembership: DialogMembershipEntity) {
        dao.insertDialog(dialogMembership)
    }

    suspend fun fetchAllDialogs(): List<DialogMembershipEntity> {
        return dao.fetchAllDialogs()
    }

    suspend fun getDialog(userGUID: String): DialogMembershipEntity {
        return dao.getDialog(userGUID)
    }

    suspend fun updateDialog(dialogMembership: DialogMembershipEntity) {
        return dao.updateDialog(dialogMembership)
    }

    suspend fun deleteDialog(dialogMembership: DialogMembershipEntity) {
        return dao.deleteDialog(dialogMembership)
    }
}