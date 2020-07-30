package su.leff.androidtemplate.framework

import su.leff.core.domain.Dialog
import su.leff.core.data.OpenDialogDataSource

class InMemoryOpenDialogStore : OpenDialogDataSource{

    private var openDialog: Dialog = Dialog.EMPTY

    override fun setOpenDialog(dialog: Dialog) {
        openDialog = dialog
    }

    override fun getOpenDialog(): Dialog = openDialog

}