package su.leff.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.leff.core.util.onClick
import su.leff.presentation.R

class HomeAdapter(val goToChat: (m: String) -> Unit) : RecyclerView.Adapter<HomeViewHolder>() {

    val list = ArrayList<Dialog>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_dialog, parent, false)
        val viewHolder = HomeViewHolder(v)
        v.onClick {
            goToChat(list[viewHolder.adapterPosition].name)
        }
        return viewHolder
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(list[position])
    }


    fun setList(newList: List<Dialog>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()

    }
}