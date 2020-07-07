package su.leff.androidtemplate.di.fragment

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import su.leff.database.AppDatabase

@Module
class FragmentModule(val context: Context) {

//    @Provides
//    @FragmentScope
//    internal fun shared(): ISharedPreferencesAPI = SharedPreferencesImpl(application)

    @Provides
    @FragmentScope
    internal fun database(): AppDatabase = AppDatabase.getInstance(context)

}