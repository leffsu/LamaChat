package su.leff.androidtemplate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import su.leff.database.entity.note.Note
import su.leff.database.entity.note.NoteRepository

class NoteViewModel(
    private val noteRepository: NoteRepository
) : ViewModel() {

    private val notes = MutableLiveData<List<Note>>()
    val allNotes: LiveData<List<Note>> = notes

    suspend fun allNotes() {
        notes.postValue(noteRepository.fetchAllNotes())
    }

    suspend fun insertNote(note: Note) {
        noteRepository.insertNote(note)
    }


    suspend fun updateNote(note: Note) {
        noteRepository.updateNote(note)
    }


    suspend fun deleteNote(note: Note) {
        noteRepository.deleteNote(note)
    }


    suspend fun getNote(noteGUID: String) {
        noteRepository.getNote(noteGUID)
    }
}