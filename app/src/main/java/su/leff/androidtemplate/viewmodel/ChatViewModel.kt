package su.leff.androidtemplate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import su.leff.database.entity.dialog.DialogEntity
import su.leff.database.entity.dialog.DialogRepository
import su.leff.database.entity.dialogmembership.DialogMembershipEntity
import su.leff.database.entity.dialogmembership.DialogMembershipRepository
import su.leff.database.entity.message.MessageEntity
import su.leff.database.entity.message.MessageRepository
import su.leff.database.entity.user.UserEntity
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

    suspend fun insertMessage(message: MessageEntity) {
        messegeRepository.insertMessage(message)
    }

    suspend fun fetchAllMessages(): List<MessageEntity> {
        return messegeRepository.fetchAllMessages()
    }

    suspend fun getMessage(userGUID: String): MessageEntity {
        return messegeRepository.getMessage(userGUID)
    }

    suspend fun updateMessage(message: MessageEntity) {
        return messegeRepository.updateMessage(message)
    }

    suspend fun deleteMessage(message: MessageEntity) {
        return messegeRepository.deleteMessage(message)
    }
    suspend fun insertDialog(dialog: DialogEntity) {
        dialogRepository.insertDialog(dialog)
    }

    suspend fun fetchAllDialogs(): List<DialogEntity> {
        return dialogRepository.fetchAllDialogs()
    }

    suspend fun getDialog(userGUID: String): DialogEntity {
        return dialogRepository.getDialog(userGUID)
    }

    suspend fun updateDialog(dialog: DialogEntity) {
        return dialogRepository.updateDialog(dialog)
    }

    suspend fun deleteDialog(dialog: DialogEntity) {
        return dialogRepository.deleteDialog(dialog)
    }
    suspend fun insertDialog(dialogMembership: DialogMembershipEntity) {
        dialogMembershipRepository.insertDialog(dialogMembership)
    }

    suspend fun fetchAllDialogsMembership(): List<DialogMembershipEntity> {
        return dialogMembershipRepository.fetchAllDialogs()
    }

    suspend fun getDialogMembership(userGUID: String): DialogMembershipEntity {
        return dialogMembershipRepository.getDialog(userGUID)
    }

    suspend fun updateDialogMembership(dialogMembership: DialogMembershipEntity) {
        return dialogMembershipRepository.updateDialog(dialogMembership)
    }

    suspend fun deleteDialogMembership(dialogMembership: DialogMembershipEntity) {
        return dialogMembershipRepository.deleteDialog(dialogMembership)
    }
    suspend fun insertUser(user: UserEntity) {
        userRepository.insertUser(user)
    }

    suspend fun fetchAllUsers(): List<UserEntity> {
        return userRepository.fetchAllUsers()
    }

    suspend fun getUser(userGUID: String): UserEntity {
        return userRepository.getUser(userGUID)
    }

    suspend fun updateUser(user: UserEntity) {
        return userRepository.updateUser(user)
    }

    suspend fun deleteUser(user: UserEntity) {
        return userRepository.deleteUser(user)
    }
}
