package su.leff.presentation.ui.home.subview.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.leff.presentation.R
import su.leff.presentation.ui.home.subview.core.SubViewWithListParent
import su.leff.core.util.onClick

class NewsAdapter(private val parent: SubViewWithListParent<News>) :
    RecyclerView.Adapter<NewsViewHolder>() {

    private val list = ArrayList<News>()

    override fun onCreateViewHolder(viewParent: ViewGroup, viewType: Int): NewsViewHolder {
        val v = LayoutInflater.from(viewParent.context)
            .inflate(R.layout.viewholder_news, viewParent, false)
        val viewHolder = NewsViewHolder(v)
        v.onClick {
            parent.onItemClick(list[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setList(newList: List<News>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}