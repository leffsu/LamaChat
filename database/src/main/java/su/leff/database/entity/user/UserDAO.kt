package su.leff.database.entity.user

import androidx.room.*

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user")
    suspend fun fetchAllUsers(): List<User>

    @Query("SELECT * FROM user WHERE userGUID =:userGUID")
    suspend fun getUser(userGUID: String): User

    @Transaction
    @Update
    suspend fun updateUser(user: User)

    @Transaction
    @Delete
    suspend fun deleteUser(user: User)
}