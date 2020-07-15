package su.leff.androidtemplate.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import su.leff.androidtemplate.app.App
import su.leff.androidtemplate.di.fragment.DaggerFragmentComponent
import su.leff.androidtemplate.di.fragment.FragmentComponent
import su.leff.androidtemplate.di.fragment.FragmentModule
import su.leff.androidtemplate.util.language.LanguageIniFileReader
import su.leff.androidtemplate.util.requireArguments
import su.leff.androidtemplate.viewmodel.NoteViewModel
import su.leff.androidtemplate.viewmodel.TranslationViewModel
import su.leff.database.AppDatabase
import su.leff.sharedpref.SharedPref
import javax.inject.Inject

open class BaseFragment : Fragment() {


    protected lateinit var database: AppDatabase
    protected lateinit var noteViewModel: NoteViewModel
    protected lateinit var sharedPref: SharedPref
    protected lateinit var translationViewModel: TranslationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = (requireActivity().application as App)
        database = app.database
        noteViewModel = app.noteViewModel
        sharedPref = app.sharedPref
        translationViewModel = app.translationViewModel
    }

    fun <T : BaseKey> getKey(): T = requireArguments.getParcelable<T>("KEY")!!
}