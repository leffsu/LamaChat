package su.leff.database.framework

import android.content.Context
import su.leff.core.data.Dialog
import su.leff.core.data.DialogDataSource
import su.leff.database.AppDatabase
import su.leff.database.entity.dialog.DialogEntity

class RoomDialogDataSource(context: Context) : DialogDataSource {

    private val dialogDAO = AppDatabase.getInstance(context).dialogDAO()

    override suspend fun add(dialog: Dialog) {
        dialogDAO.insertDialog(
            DialogEntity(
                dialogGUID = dialog.dialogGUID,
                name = dialog.name,
                isGroup = dialog.isGroup
            )
        )
    }

    override suspend fun readAll(): List<Dialog> =
        dialogDAO.fetchAllDialogs().map { Dialog(it.dialogGUID, it.name, it.isGroup) }

    override suspend fun remove(dialog: Dialog) {
        dialogDAO.deleteDialog(
            DialogEntity(
                dialogGUID = dialog.dialogGUID,
                name = dialog.name,
                isGroup = dialog.isGroup
            )
        )
    }
}