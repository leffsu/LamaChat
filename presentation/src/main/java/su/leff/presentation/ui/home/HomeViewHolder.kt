package su.leff.presentation.ui.home

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_dialog.view.*
import su.leff.presentation.util.date.DateReceiver
import java.text.SimpleDateFormat
import java.util.*

class HomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    fun bind(dialog: Dialog) {
        val uri: Uri =
            Uri.parse("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png")
        itemView.imgAvatar.setImageURI(uri)
        itemView.txvName.text = dialog.name
        itemView.txvText.text = dialog.text
        val dateFormat= SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        itemView.txvDate.text = DateReceiver.getCurrectDate(dialog.calendar)
    }
}