package su.leff.androidtemplate.ui.home

import kotlinx.android.parcel.Parcelize
import su.leff.androidtemplate.navigation.BaseKey

@Parcelize
data class HomeKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = HomeFragment()
}