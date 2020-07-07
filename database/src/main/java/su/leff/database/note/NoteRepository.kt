package su.leff.database.note

class NoteRepository(private val dao: NoteDAO) {

    suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    suspend fun fetchAllNotes(): List<Note> {
        return dao.fetchAllNotes()
    }

    suspend fun getNote(noteGUID: String): Note {
        return dao.getNote(noteGUID)
    }

    suspend fun updateNote(note: Note) {
        return dao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}