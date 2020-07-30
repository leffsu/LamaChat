package su.leff.presentation.ui.home.news

import kotlinx.android.parcel.Parcelize
import su.leff.presentation.navigation.BaseKey

@Parcelize
data class NewsKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = NewsFragment()
}