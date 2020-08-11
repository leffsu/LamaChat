package su.leff.presentation.ui.home.subview.core

import androidx.constraintlayout.widget.ConstraintLayout
import su.leff.presentation.ui.home.subview.chatlist.Chat

abstract class SubViewControllerWithList<T>(layout: ConstraintLayout,
                                            protected val parent: SubViewWithListParent<T>): SubViewController(layout) {

    abstract fun setList(t: List<T>)

    fun onItemClick(t: T) {
        parent.onItemClick(t)
    }

}