package su.leff.androidtemplate.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.leff.androidtemplate.R
import su.leff.androidtemplate.ui.home.Dialog
import su.leff.androidtemplate.ui.home.HomeViewHolder

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