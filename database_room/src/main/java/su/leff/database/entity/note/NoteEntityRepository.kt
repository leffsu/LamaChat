package su.leff.database.entity.note

class NoteEntityRepository(private val dao: NoteEntityDAO) {

    suspend fun insertNote(note: NoteEntity) {
        dao.insertNote(note)
    }

    suspend fun fetchAllNotes(): List<NoteEntity> {
        return dao.fetchAllNotes()
    }

    suspend fun getNote(noteGUID: String): NoteEntity {
        return dao.getNote(noteGUID)
    }

    suspend fun updateNote(note: NoteEntity) {
        return dao.updateNote(note)
    }

    suspend fun deleteNote(note: NoteEntity) {
        return dao.deleteNote(note)
    }
}