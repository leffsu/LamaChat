package su.leff.presentation.ui.home.subview.news

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.subview_news.view.*
import su.leff.presentation.ui.home.subview.core.SubViewControllerWithList
import su.leff.presentation.ui.home.subview.core.SubViewWithListParent

class NewsController(layout: ConstraintLayout, parent: SubViewWithListParent<News>) :
    SubViewControllerWithList<News>(layout, parent) {

    private val adapter = NewsAdapter(parent)

    init {
        layout.rvNews.layoutManager =
            LinearLayoutManager(parent.context, LinearLayoutManager.VERTICAL, false)
        layout.rvNews.adapter = adapter

        adapter.setList(listOf(
            News(0L, "asd"),
            News(0L, "asd"),
            News(0L, "asd"),
            News(0L, "asd"),
            News(0L, "asd"),
            News(0L, "asd"),
            News(0L, "asd"),
            News(0L, "asd"),
            News(0L, "asd")
        ))
    }

    override fun show() {
        super.show()
        layout.rvNews.layoutManager =
            LinearLayoutManager(parent.context, LinearLayoutManager.VERTICAL, false)
        layout.rvNews.adapter = adapter
        layout.rvNews.invalidate()
    }

    override fun setList(t: List<News>) {
        adapter.setList(t)
    }
}