package su.leff.androidtemplate.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import su.leff.androidtemplate.di.fragment.DaggerFragmentComponent
import su.leff.androidtemplate.di.fragment.FragmentComponent
import su.leff.androidtemplate.di.fragment.FragmentModule
import su.leff.androidtemplate.util.requireArguments
import su.leff.database.AppDatabase
import javax.inject.Inject

open class BaseFragment : Fragment() {

    val component: FragmentComponent by lazy {
        DaggerFragmentComponent
            .builder()
            .fragmentModule(FragmentModule(requireContext()))
            .build()
    }

    @Inject
    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)
    }

    fun <T : BaseKey> getKey(): T = requireArguments.getParcelable<T>("KEY")!!
}