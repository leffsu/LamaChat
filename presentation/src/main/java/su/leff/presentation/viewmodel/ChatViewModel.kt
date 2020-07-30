package su.leff.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import su.leff.core.data.Dialog
import su.leff.core.interactors.AddDialog
import su.leff.core.interactors.GetDialogs
import su.leff.core.interactors.RemoveDialog
import su.leff.presentation.entity.DialogPresentation
import javax.inject.Inject

class ChatViewModel @Inject constructor(
    private val addDialog: AddDialog,
    private val getDialogs: GetDialogs,
    private val removeDialog: RemoveDialog
) : ViewModel() {

    private val dialogs = MutableLiveData<List<DialogPresentation>>()
    val allDialogs: LiveData<List<DialogPresentation>> = dialogs

    fun addDialog(dialog: DialogPresentation) {
        GlobalScope.launch {
            addDialog(Dialog(dialog.dialogGUID, dialog.name, dialog.isGroup))
        }
    }

    init {
        GlobalScope.launch {
            dialogs.postValue(getDialogs().map {
                DialogPresentation(
                    it.dialogGUID,
                    it.name,
                    it.isGroup
                )
            })
        }
    }
}