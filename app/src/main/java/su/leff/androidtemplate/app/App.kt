package su.leff.androidtemplate.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import su.leff.androidtemplate.R
import su.leff.androidtemplate.di.application.AppComponent
import su.leff.androidtemplate.di.application.AppModule
import su.leff.androidtemplate.di.application.DaggerAppComponent
import su.leff.androidtemplate.util.language.LanguageIniFileReader
import su.leff.androidtemplate.util.language.LanguageState
import su.leff.androidtemplate.viewmodel.NoteViewModel
import su.leff.androidtemplate.viewmodel.TranslationViewModel
import su.leff.database.AppDatabase
import su.leff.sharedpref.SharedPref
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var noteViewModel: NoteViewModel

    @Inject
    lateinit var database: AppDatabase

    @Inject
    lateinit var sharedPref: SharedPref

    @Inject
    lateinit var translationViewModel: TranslationViewModel

    private val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        component.inject(this)

        when (resources.getString(R.string.language_id).toInt()) {
            0 -> {
                translationViewModel.postLanguage(LanguageState.ENGLISH)
            }
            1 -> {
                translationViewModel.postLanguage(LanguageState.RUSSIAN)
            }
        }
    }
}