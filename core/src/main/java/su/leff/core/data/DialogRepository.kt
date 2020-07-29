package su.leff.core.data

class DialogRepository(private val dialogDataSource: DialogDataSource,
                       private val openDialogDataSource: OpenDialogDataSource) {

    suspend fun addDialog(dialog: Dialog) = dialogDataSource.add(dialog)

    suspend fun getDialogs() = dialogDataSource.readAll()

    suspend fun removeDialog(dialog: Dialog) = dialogDataSource.remove(dialog)

    suspend fun setOpenDialog(dialog: Dialog) = openDialogDataSource.setOpenDialog(dialog)

    suspend fun getOpenDialog() = openDialogDataSource.getOpenDialog()

}