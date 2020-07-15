package su.leff.database.entity.dialogmembership

import androidx.room.*

@Dao
interface DialogMembershipDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDialog(dialogMembership: DialogMembership)

    @Query("SELECT * FROM dialogmembership")
    suspend fun fetchAllDialogs(): List<DialogMembership>

    @Query("SELECT * FROM dialogmembership WHERE userGUID =:dialogMembershipGUID")
    suspend fun getDialog(dialogMembershipGUID: String): DialogMembership

    @Transaction
    @Update
    suspend fun updateDialog(dialogMembership: DialogMembership)

    @Transaction
    @Delete
    suspend fun deleteDialog(dialogMembership: DialogMembership)
}