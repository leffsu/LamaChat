package su.leff.presentation.navigation

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import su.leff.presentation.viewmodel.ChatViewModel
import su.leff.presentation.viewmodel.TranslationViewModel

abstract class BaseKey : Parcelable {
    val fragmentTag: String
        get() = toString()

    fun newFragment(): Fragment = createFragment().apply {
        arguments = (arguments ?: Bundle()).also { bundle ->
            bundle.putParcelable("KEY", this@BaseKey)
        }
    }

    protected abstract fun createFragment(
    ): BaseFragment
}