package su.leff.database.entity.dialog

import androidx.room.*

@Dao
interface DialogDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDialog(dialog: Dialog)

    @Query("SELECT * FROM user")
    suspend fun fetchAllDialogs(): List<Dialog>

    @Query("SELECT * FROM user WHERE userGUID =:userGUID")
    suspend fun getDialog(userGUID: String): Dialog

    @Transaction
    @Update
    suspend fun updateDialog(dialog: Dialog)

    @Transaction
    @Delete
    suspend fun deleteDialog(dialog: Dialog)
}