package su.leff.database.entity.user

import androidx.room.*

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun fetchAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user WHERE userGUID =:userGUID")
    suspend fun getUser(userGUID: String): UserEntity

    @Transaction
    @Update
    suspend fun updateUser(user: UserEntity)

    @Transaction
    @Delete
    suspend fun deleteUser(user: UserEntity)
}