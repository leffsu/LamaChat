package su.leff.core.data

import su.leff.core.domain.Dialog
import su.leff.core.domain.Message

interface MessageDataSource {

    suspend fun add(dialog: Dialog, message: Message)

    suspend fun read(dialog: Dialog): List<Message>

    suspend fun remove(dialog: Dialog, message: Message)
}