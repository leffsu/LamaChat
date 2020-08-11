package su.leff.presentation.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.leff.presentation.R
import su.leff.presentation.ui.chat.ChatViewHolder
import su.leff.presentation.ui.home.subview.chatlist.Chat

class ChatAdapter() : RecyclerView.Adapter<ChatViewHolder>() {

    val list = ArrayList<Chat>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_massedge, parent, false)
        return ChatViewHolder(v)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(list[position])
    }
    fun setList(newList: List<Chat>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()

    }

}