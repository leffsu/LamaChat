package su.leff.androidtemplate.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import su.leff.androidtemplate.R
import su.leff.androidtemplate.di.application.AppComponent
import su.leff.androidtemplate.di.application.AppModule
import su.leff.androidtemplate.di.application.DaggerAppComponent
import su.leff.presentation.util.language.LanguageState
import su.leff.presentation.viewmodel.TranslationViewModel
import su.leff.database.AppDatabase
import su.leff.presentation.di.DependencyLinker
import su.leff.presentation.viewmodel.ChatViewModel
import su.leff.sharedpref.SharedPref
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var database: AppDatabase
    @Inject
    lateinit var sharedPref: SharedPref
    @Inject
    lateinit var translationViewModel: TranslationViewModel
    @Inject
    lateinit var chatViewModel: ChatViewModel

    private val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        Fresco.initialize(this)
        component.inject(this)

        DependencyLinker.chatViewModel = chatViewModel
        DependencyLinker.translationViewModel = translationViewModel

        when (resources.getString(R.string.language_id).toInt()) {
            0 -> {
                translationViewModel.postLanguage(LanguageState.EN)
            }
            1 -> {
                translationViewModel.postLanguage(LanguageState.RU)
            }
        }
    }

    companion object {
        lateinit var app: App
    }
}