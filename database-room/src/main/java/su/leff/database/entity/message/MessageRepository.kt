package su.leff.database.entity.message

class MessageRepository(private val dao: MessageDAO) {

    suspend fun insertMessage(message: MessageEntity) {
        dao.insertMessage(message)
    }

    suspend fun fetchAllMessages(): List<MessageEntity> {
        return dao.fetchAllMessages()
    }

    suspend fun getMessage(userGUID: String): MessageEntity {
        return dao.getMessage(userGUID)
    }

    suspend fun updateMessage(message: MessageEntity) {
        return dao.updateMessage(message)
    }

    suspend fun deleteMessage(message: MessageEntity) {
        return dao.deleteMessage(message)
    }
}