package su.leff.presentation.ui.chat

import kotlinx.android.parcel.Parcelize
import su.leff.presentation.navigation.BaseKey
import su.leff.androidtemplate.ui.chat.ChatFragment

@Parcelize
data class ChatKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = ChatFragment()
}