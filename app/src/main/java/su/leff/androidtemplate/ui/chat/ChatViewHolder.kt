package su.leff.androidtemplate.ui.chat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_dialog.view.*
import kotlinx.android.synthetic.main.viewholder_massedge.view.*
import su.leff.androidtemplate.ui.home.Dialog
import su.leff.androidtemplate.util.date.DateReceiver
import java.text.SimpleDateFormat
import java.util.*

class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(chat: Chat) {
        itemView.txvTitle.text = chat.title
        itemView.txvMes.text = chat.mess
        val dateFormat= SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        itemView.txvDateMess.text = DateReceiver.getCurrectDate(chat.calendar)
    }
}
