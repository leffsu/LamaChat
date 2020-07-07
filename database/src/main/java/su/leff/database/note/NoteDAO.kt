package su.leff.database.note

import androidx.room.*

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM note")
    suspend fun fetchAllNotes(): List<Note>

    @Query("SELECT * FROM note WHERE noteGUID =:noteGUID")
    suspend fun getNote(noteGUID: String): Note

    @Transaction
    @Update
    suspend fun updateNote(note: Note)

    @Transaction
    @Delete
    suspend fun deleteNote(note: Note)
}