package su.leff.presentation.ui.home.subview.core

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import su.leff.presentation.util.hide
import su.leff.presentation.util.show

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