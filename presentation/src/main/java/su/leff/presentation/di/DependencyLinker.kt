package su.leff.presentation.di

import su.leff.presentation.viewmodel.ChatViewModel
import su.leff.presentation.viewmodel.TranslationViewModel

object DependencyLinker {
    lateinit var translationViewModel: TranslationViewModel
    lateinit var chatViewModel: ChatViewModel
}