package su.leff.database.entity.message

class MessageRepository(private val dao: MessageDAO) {

    suspend fun insertMessage(message: Message) {
        dao.insertMessage(message)
    }

    suspend fun fetchAllMessages(): List<Message> {
        return dao.fetchAllMessages()
    }

    suspend fun getMessage(userGUID: String): Message {
        return dao.getMessage(userGUID)
    }

    suspend fun updateMessage(message: Message) {
        return dao.updateMessage(message)
    }

    suspend fun deleteMessage(message: Message) {
        return dao.deleteMessage(message)
    }
}