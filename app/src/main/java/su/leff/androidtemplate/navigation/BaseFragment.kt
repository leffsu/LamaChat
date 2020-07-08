package su.leff.androidtemplate.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import su.leff.androidtemplate.app.App
import su.leff.androidtemplate.di.fragment.DaggerFragmentComponent
import su.leff.androidtemplate.di.fragment.FragmentComponent
import su.leff.androidtemplate.di.fragment.FragmentModule
import su.leff.androidtemplate.util.requireArguments
import su.leff.androidtemplate.viewmodel.NoteViewModel
import su.leff.database.AppDatabase
import javax.inject.Inject

open class BaseFragment : Fragment() {


    lateinit var database: AppDatabase
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = (requireActivity().application as App).database
        noteViewModel = (requireActivity().application as App).noteViewModel
    }

    fun <T : BaseKey> getKey(): T = requireArguments.getParcelable<T>("KEY")!!
}