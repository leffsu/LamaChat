package su.leff.database.entity.note

import androidx.room.*

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Query("SELECT * FROM note")
    suspend fun fetchAllNotes(): List<NoteEntity>

    @Query("SELECT * FROM note WHERE noteGUID =:noteGUID")
    suspend fun getNote(noteGUID: String): NoteEntity

    @Transaction
    @Update
    suspend fun updateNote(note: NoteEntity)

    @Transaction
    @Delete
    suspend fun deleteNote(note: NoteEntity)
}