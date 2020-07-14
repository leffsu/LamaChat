package su.leff.database.entity.message

import androidx.room.*

@Dao
interface MessageDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: Message)

    @Query("SELECT * FROM user")
    suspend fun fetchAllMessages(): List<Message>

    @Query("SELECT * FROM user WHERE userGUID =:userGUID")
    suspend fun getMessage(userGUID: String): Message

    @Transaction
    @Update
    suspend fun updateMessage(message: Message)

    @Transaction
    @Delete
    suspend fun deleteMessage(message: Message)
}