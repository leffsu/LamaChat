package su.leff.androidtemplate.ui.home.chatlist

import kotlinx.android.parcel.Parcelize
import su.leff.androidtemplate.navigation.BaseKey
import su.leff.androidtemplate.ui.home.HomeFragment

@Parcelize
data class ChatListKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = ChatListFragment()
}