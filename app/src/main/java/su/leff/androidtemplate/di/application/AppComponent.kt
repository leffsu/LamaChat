package su.leff.androidtemplate.di.application

import android.app.Application
import dagger.Component
import su.leff.androidtemplate.app.App
import su.leff.androidtemplate.navigation.BaseFragment

@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(application: App)
}