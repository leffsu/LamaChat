package su.leff.core.interactors

import su.leff.core.domain.Dialog
import su.leff.core.data.DialogRepository

class RemoveDialog(private val dialogRepository: DialogRepository) {
    suspend operator fun invoke(dialog: Dialog) = dialogRepository.removeDialog(dialog)
}