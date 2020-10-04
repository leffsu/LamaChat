package su.leff.presentation.ui.home.subview.core

import androidx.constraintlayout.widget.ConstraintLayout
import su.leff.core.util.hide
import su.leff.core.util.show

abstract class SubViewController(val layout: ConstraintLayout) {

    fun hide(){
        layout.hide()
    }

    open fun show(){
        layout.show()
    }

    fun showIf(condition: () -> Boolean) {
        if (condition()) {
            show()
        } else {
            hide()
        }
    }
}