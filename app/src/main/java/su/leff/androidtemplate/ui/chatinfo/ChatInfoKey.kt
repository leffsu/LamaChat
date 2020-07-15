package su.leff.androidtemplate.ui.chatinfo

import kotlinx.android.parcel.Parcelize
import su.leff.androidtemplate.navigation.BaseKey
import su.leff.androidtemplate.ui.chat.ChatFragment

@Parcelize
data class ChatInfoKey(private val placeholder: String = ""):BaseKey() {
    override fun createFragment() = ChatInfoFragment()
}
