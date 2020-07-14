package su.leff.androidtemplate.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.leff.androidtemplate.R
import su.leff.androidtemplate.util.onClick

class HomeAdapter(val goToChat: () -> Unit) : RecyclerView.Adapter<HomeViewHolder>() {

    val list = ArrayList<Dialog>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_dialog, parent, false)
        v.onClick {
            goToChat()
        }
        return HomeViewHolder(v)
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