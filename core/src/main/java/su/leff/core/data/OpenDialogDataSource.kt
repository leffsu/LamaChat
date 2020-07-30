package su.leff.core.data

import su.leff.core.domain.Dialog

interface OpenDialogDataSource {

    fun setOpenDialog(dialog: Dialog)

    fun getOpenDialog(): Dialog

}