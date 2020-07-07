package su.leff.androidtemplate.ui.settings

import kotlinx.android.parcel.Parcelize
import su.leff.androidtemplate.navigation.BaseKey

@Parcelize
data class SettingsKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = SettingsFragment()
}