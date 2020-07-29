package su.leff.androidtemplate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import su.leff.database.entity.note.NoteEntity
import su.leff.database.entity.note.NoteRepository

class NoteViewModel(
    private val noteRepository: NoteRepository
) : ViewModel() {

    private val notes = MutableLiveData<List<NoteEntity>>()
    val allNotes: LiveData<List<NoteEntity>> = notes

    suspend fun allNotes() {
        notes.postValue(noteRepository.fetchAllNotes())
    }

    suspend fun insertNote(note: NoteEntity) {
        noteRepository.insertNote(note)
    }


    suspend fun updateNote(note: NoteEntity) {
        noteRepository.updateNote(note)
    }


    suspend fun deleteNote(note: NoteEntity) {
        noteRepository.deleteNote(note)
    }


    suspend fun getNote(noteGUID: String) {
        noteRepository.getNote(noteGUID)
    }
}