package su.leff.database.entity.dialogmembership

import androidx.room.*

@Dao
interface DialogMembershipEntityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDialog(dialogMembership: DialogMembershipEntity)

    @Query("SELECT * FROM dialogmembership")
    suspend fun fetchAllDialogs(): List<DialogMembershipEntity>

    @Query("SELECT * FROM dialogmembership WHERE userGUID =:dialogMembershipGUID")
    suspend fun getDialog(dialogMembershipGUID: String): DialogMembershipEntity

    @Transaction
    @Update
    suspend fun updateDialog(dialogMembership: DialogMembershipEntity)

    @Transaction
    @Delete
    suspend fun deleteDialog(dialogMembership: DialogMembershipEntity)
}