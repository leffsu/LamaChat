package su.leff.androidtemplate.di.application

import android.content.Context
import dagger.Module
import dagger.Provides
import su.leff.androidtemplate.di.fragment.FragmentScope
import su.leff.androidtemplate.viewmodel.NoteViewModel
import su.leff.database.AppDatabase
import su.leff.database.note.NoteRepository

@Module
class AppModule(val context: Context) {

    @Provides
    @FragmentScope
    internal fun database(): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @AppScope
    internal fun noteViewModel(): NoteViewModel = NoteViewModel(NoteRepository(database().noteDAO()))

}