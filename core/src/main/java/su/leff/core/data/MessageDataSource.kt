package su.leff.core.data

interface MessageDataSource {

    suspend fun add(dialog: Dialog, message: Message)

    suspend fun read(dialog: Dialog): List<Message>

    suspend fun remove(dialog: Dialog, message: Message)
}