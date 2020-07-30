package su.leff.presentation.util

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun <T : View> T.showIf(condition: (T) -> Boolean): T {
    if (condition(this)) {
        show()
    } else {
        hide()
    }

    return this
}

fun <T : View> T.hideIf(condition: (T) -> Boolean): T {
    if (condition(this)) {
        hide()
    } else {
        show()
    }

    return this
}

suspend fun <T> ViewModel.waitFor(block: suspend CoroutineScope.() -> T) {
    withContext(viewModelScope.coroutineContext) {
        block.invoke(viewModelScope)
    }
}