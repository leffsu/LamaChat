package su.leff.database.entity.dialog

import androidx.room.*

@Dao
interface DialogEntityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDialog(dialog: DialogEntity)

    @Query("SELECT * FROM dialog")
    suspend fun fetchAllDialogs(): List<DialogEntity>

    @Query("SELECT * FROM dialog WHERE dialogGUID =:dialogGUID")
    suspend fun getDialog(dialogGUID: String): DialogEntity

    @Transaction
    @Update
    suspend fun updateDialog(dialog: DialogEntity)

    @Transaction
    @Delete
    suspend fun deleteDialog(dialog: DialogEntity)
}