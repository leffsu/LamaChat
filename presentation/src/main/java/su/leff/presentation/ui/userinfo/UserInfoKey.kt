package su.leff.presentation.ui.userinfo

import kotlinx.android.parcel.Parcelize
import su.leff.presentation.navigation.BaseKey

@Parcelize
data class UserInfoKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = UserInfoFragment()
}