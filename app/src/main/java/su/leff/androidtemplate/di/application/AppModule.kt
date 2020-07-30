package su.leff.androidtemplate.di.application

import android.content.Context
import dagger.Module
import dagger.Provides
import su.leff.androidtemplate.framework.InMemoryOpenDialogStore
import su.leff.presentation.viewmodel.ChatViewModel
import su.leff.presentation.viewmodel.TranslationViewModel
import su.leff.core.data.DialogDataSource
import su.leff.core.data.DialogRepository
import su.leff.core.data.OpenDialogDataSource
import su.leff.core.interactors.AddDialog
import su.leff.core.interactors.GetDialogs
import su.leff.core.interactors.RemoveDialog
import su.leff.database.AppDatabase
import su.leff.database.entity.note.NoteEntityRepository
import su.leff.database.framework.RoomDialogDataSource
import su.leff.sharedpref.SharedPref
import su.leff.sharedpref.SharedPrefImpl
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    internal fun database(): AppDatabase = AppDatabase.getInstance(context)

    internal fun dialogDataSource(): DialogDataSource = RoomDialogDataSource(context)

    internal fun openDialogDataSource(): OpenDialogDataSource = InMemoryOpenDialogStore()

    internal fun dialogRepository(): DialogRepository =
        DialogRepository(dialogDataSource(), openDialogDataSource())

    @Provides
    @AppScope
    internal fun chatViewModel(): ChatViewModel = ChatViewModel(
        AddDialog(dialogRepository()),
        GetDialogs(dialogRepository()),
        RemoveDialog(dialogRepository())
    )

    @Provides
    @AppScope
    internal fun sharedPref(): SharedPref = SharedPrefImpl(context)

    @Provides
    @AppScope
    internal fun translationViewModel(): TranslationViewModel = TranslationViewModel(context)
}