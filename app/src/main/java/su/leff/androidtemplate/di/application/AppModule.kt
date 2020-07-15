package su.leff.androidtemplate.di.application

import android.content.Context
import dagger.Module
import dagger.Provides
import su.leff.androidtemplate.di.fragment.FragmentScope
import su.leff.androidtemplate.viewmodel.ChatViewModel
import su.leff.androidtemplate.viewmodel.NoteViewModel
import su.leff.database.AppDatabase
import su.leff.database.entity.dialog.DialogRepository
import su.leff.database.entity.dialogmembership.DialogMembershipRepository
import su.leff.database.entity.message.MessageRepository
import su.leff.database.entity.note.NoteRepository
import su.leff.database.entity.user.UserRepository
import su.leff.sharedpref.SharedPref
import su.leff.sharedpref.SharedPrefImpl

@Module
class AppModule(private val context: Context) {

    @Provides
    @FragmentScope
    internal fun database(): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @AppScope
    internal fun noteViewModel(): NoteViewModel =
        NoteViewModel(NoteRepository(database().noteDAO()))

    @Provides
    @AppScope
    internal fun messageViewModel(): ChatViewModel = ChatViewModel(
        MessageRepository(database().messageDAO()),
        DialogRepository(database().dialogDAO()),
        DialogMembershipRepository(database().dialogMembershaipDAO()),
        UserRepository(database().userDAO())
    )

    @Provides
    @AppScope
    internal fun sharedPref(): SharedPref = SharedPrefImpl(context)

}