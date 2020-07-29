package su.leff.core.interactors

import su.leff.core.data.Dialog
import su.leff.core.data.DialogRepository

class GetDialogs(private val dialogRepository: DialogRepository) {
    suspend operator fun invoke() = dialogRepository.getDialogs()
}