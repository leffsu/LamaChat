package su.leff.presentation.di.fragment

import android.app.Application
import dagger.Module
import dagger.Provides
import su.leff.presentation.di.DependencyLinker
import su.leff.presentation.viewmodel.ChatViewModel
import su.leff.presentation.viewmodel.TranslationViewModel

@Module
class FragmentModule() {


    @Provides
    @FragmentScope
    internal fun translationViewModel(): TranslationViewModel = DependencyLinker.translationViewModel

    @Provides
    @FragmentScope
    internal fun chatViewModel(): ChatViewModel = DependencyLinker.chatViewModel

//    @Provides
//    @FragmentScope
//    internal fun database(): AppDatabase = AppDatabase.getInstance(context)

}