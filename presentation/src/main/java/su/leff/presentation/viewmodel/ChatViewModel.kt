package su.leff.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import su.leff.core.interactors.AddDialog
import su.leff.core.interactors.GetDialogs
import su.leff.core.interactors.RemoveDialog
import su.leff.presentation.entity.DialogPresentation
import su.leff.core.util.waitFor
import javax.inject.Inject

class ChatViewModel @Inject constructor(
    private val addDialog: AddDialog,
    private val getDialogs: GetDialogs,
    private val removeDialog: RemoveDialog
) : ViewModel() {

    private val dialogs = MutableLiveData<List<DialogPresentation>>()
    val allDialogs: LiveData<List<DialogPresentation>> = dialogs

    fun addDialog(dialog: DialogPresentation) = viewModelScope.launch {
        waitFor {
            addDialog(dialog.toDialog())
        }
        loadDialogs()
    }

    fun loadDialogs() = viewModelScope.launch {
        dialogs.postValue(getDialogs().map {
            DialogPresentation.fromDialog(it)
        })
    }

    init {
        loadDialogs()
    }
}