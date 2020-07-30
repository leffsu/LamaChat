package su.leff.presentation.ui.chatinfo

import kotlinx.android.parcel.Parcelize
import su.leff.presentation.navigation.BaseKey

@Parcelize
data class ChatInfoKey(private val placeholder: String = ""): BaseKey() {
    override fun createFragment() = ChatInfoFragment()
}
