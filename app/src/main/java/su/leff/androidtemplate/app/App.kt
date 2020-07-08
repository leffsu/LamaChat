package su.leff.androidtemplate.app

import android.app.Application
import su.leff.androidtemplate.di.application.AppComponent
import su.leff.androidtemplate.di.application.AppModule
import su.leff.androidtemplate.di.application.DaggerAppComponent
import su.leff.androidtemplate.viewmodel.NoteViewModel
import su.leff.database.AppDatabase
import javax.inject.Inject

class App : Application(){

    @Inject
    lateinit var noteViewModel: NoteViewModel

    @Inject
    lateinit var database: AppDatabase

    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}