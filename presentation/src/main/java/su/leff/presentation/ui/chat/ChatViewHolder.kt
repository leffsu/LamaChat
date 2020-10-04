package su.leff.presentation.ui.chat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import su.leff.presentation.ui.home.subview.chatlist.Chat

class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(chat: Chat) {
//        itemView.txvTitle.text = chat.title
//        itemView.txvMes.text = chat.mess
//        val dateFormat= SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
//
//        itemView.txvDateMess.text = DateReceiver.getCurrectDate(chat.calendar)
    }
}
