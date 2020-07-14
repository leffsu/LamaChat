package su.leff.androidtemplate.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_dialog.view.*

class HomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    fun bind(dialog: Dialog) {
        itemView.txvName.text = dialog.name
        itemView.txvText.text = dialog.text

    }
}