package su.leff.database.entity.message

import androidx.room.*

@Dao
interface MessageEntityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: MessageEntity)

    @Query("SELECT * FROM message")
    suspend fun fetchAllMessages(): List<MessageEntity>

    @Query("SELECT * FROM message WHERE messageGUID =:messageGUID")
    suspend fun getMessage(messageGUID: String): MessageEntity

    @Transaction
    @Update
    suspend fun updateMessage(message: MessageEntity)

    @Transaction
    @Delete
    suspend fun deleteMessage(message: MessageEntity)
}