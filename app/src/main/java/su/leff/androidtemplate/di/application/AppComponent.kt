package su.leff.androidtemplate.di.application

import dagger.Component
import su.leff.androidtemplate.app.App

@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(application: App)
}