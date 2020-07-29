package su.leff.androidtemplate.framework

import su.leff.core.interactors.AddDialog
import su.leff.core.interactors.GetDialogs
import su.leff.core.interactors.RemoveDialog

data class Interactors(
    val addDialog: AddDialog,
    val removeDialog: RemoveDialog,
    val getDialogs: GetDialogs
)