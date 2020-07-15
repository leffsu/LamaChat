package su.leff.androidtemplate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import su.leff.database.entity.dialog.Dialog
import su.leff.database.entity.dialog.DialogRepository
import su.leff.database.entity.dialogmembership.DialogMembership
import su.leff.database.entity.dialogmembership.DialogMembershipRepository
import su.leff.database.entity.message.Message
import su.leff.database.entity.message.MessageRepository
import su.leff.database.entity.note.Note
import su.leff.database.entity.note.NoteRepository
import su.leff.database.entity.user.User
import su.leff.database.entity.user.UserRepository

class ChatViewModel (
    private val messegeRepository: MessageRepository,
    private val dialogRepository: DialogRepository,
    private val dialogMembershipRepository: DialogMembershipRepository,
    private val userRepository: UserRepository

):ViewModel(){

    private val messege = MutableLiveData<List<MessageRepository>>()
    val allMessage: LiveData<List<MessageRepository>> = messege

    private val dialog = MutableLiveData<List<DialogRepository>>()
    val allDialog: LiveData<List<DialogRepository>> = dialog

    private val dialogMembership = MutableLiveData<List<DialogMembershipRepository>>()
    val allDialogMembership: LiveData<List<DialogMembershipRepository>> = dialogMembership

    private val user = MutableLiveData<List<UserRepository>>()
    val allUser: LiveData<List<UserRepository>> = user

    suspend fun insertMessage(message: Message) {
        messegeRepository.insertMessage(message)
    }

    suspend fun fetchAllMessages(): List<Message> {
        return messegeRepository.fetchAllMessages()
    }

    suspend fun getMessage(userGUID: String): Message {
        return messegeRepository.getMessage(userGUID)
    }

    suspend fun updateMessage(message: Message) {
        return messegeRepository.updateMessage(message)
    }

    suspend fun deleteMessage(message: Message) {
        return messegeRepository.deleteMessage(message)
    }
    suspend fun insertDialog(dialog: Dialog) {
        dialogRepository.insertDialog(dialog)
    }

    suspend fun fetchAllDialogs(): List<Dialog> {
        return dialogRepository.fetchAllDialogs()
    }

    suspend fun getDialog(userGUID: String): Dialog {
        return dialogRepository.getDialog(userGUID)
    }

    suspend fun updateDialog(dialog: Dialog) {
        return dialogRepository.updateDialog(dialog)
    }

    suspend fun deleteDialog(dialog: Dialog) {
        return dialogRepository.deleteDialog(dialog)
    }
    suspend fun insertDialog(dialogMembership: DialogMembership) {
        dialogMembershipRepository.insertDialog(dialogMembership)
    }

    suspend fun fetchAllDialogsMembership(): List<DialogMembership> {
        return dialogMembershipRepository.fetchAllDialogs()
    }

    suspend fun getDialogMembership(userGUID: String): DialogMembership {
        return dialogMembershipRepository.getDialog(userGUID)
    }

    suspend fun updateDialogMembership(dialogMembership: DialogMembership) {
        return dialogMembershipRepository.updateDialog(dialogMembership)
    }

    suspend fun deleteDialogMembership(dialogMembership: DialogMembership) {
        return dialogMembershipRepository.deleteDialog(dialogMembership)
    }
    suspend fun insertUser(user: User) {
        userRepository.insertUser(user)
    }

    suspend fun fetchAllUsers(): List<User> {
        return userRepository.fetchAllUsers()
    }

    suspend fun getUser(userGUID: String): User {
        return userRepository.getUser(userGUID)
    }

    suspend fun updateUser(user: User) {
        return userRepository.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        return userRepository.deleteUser(user)
    }
}
