package su.leff.presentation.ui.home.subview.chatlist

import androidx.constraintlayout.widget.ConstraintLayout
import su.leff.presentation.ui.home.subview.core.SubViewControllerWithList
import su.leff.presentation.ui.home.subview.core.SubViewWithListParent

class ChatListController(
    layout: ConstraintLayout,
    controller: SubViewWithListParent<Chat>
) : SubViewControllerWithList<Chat>(layout, controller) {

    override fun setList(t: List<Chat>) {

    }
}