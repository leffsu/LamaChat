package su.leff.presentation.ui.home.subview.news

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_news.view.*

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(news: News) {
        itemView.txvTitle.text = news.text

    }
}