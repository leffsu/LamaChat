package su.leff.presentation.entity

import su.leff.core.domain.Dialog

class DialogPresentation(
    val dialogGUID: String,
    val name: String,
    val isGroup: Boolean
) {
    fun toDialog(): Dialog {
        return Dialog(dialogGUID, name, isGroup)
    }

    companion object {
        fun fromDialog(dialog: Dialog): DialogPresentation {
            return DialogPresentation(dialog.dialogGUID, dialog.name, dialog.isGroup)
        }
    }
}