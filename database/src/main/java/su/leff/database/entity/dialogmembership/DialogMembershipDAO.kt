package su.leff.database.entity.dialogmembership

import androidx.room.*

@Dao
interface DialogMembershipDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDialog(dialogMembership: DialogMembership)

    @Query("SELECT * FROM user")
    suspend fun fetchAllDialogs(): List<DialogMembership>

    @Query("SELECT * FROM user WHERE userGUID =:userGUID")
    suspend fun getDialog(userGUID: String): DialogMembership

    @Transaction
    @Update
    suspend fun updateDialog(dialogMembership: DialogMembership)

    @Transaction
    @Delete
    suspend fun deleteDialog(dialogMembership: DialogMembership)
}