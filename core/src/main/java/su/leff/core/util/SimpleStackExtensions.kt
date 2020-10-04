package su.leff.core.util

import android.app.Activity
import androidx.fragment.app.Fragment
import android.view.View
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator

val Fragment.requireArguments
    get() = this.arguments ?: throw IllegalStateException("Arguments should exist!")

inline fun View.onClick(crossinline click: (View) -> Unit) {
    setOnClickListener { view ->
        click(view)
    }
}

fun Backstack.replaceHistory(vararg keys: Any) {
    this.setHistory(keys.toList(), StateChange.REPLACE)
}

val Activity.backstack: Backstack get() = Navigator.getBackstack(this)

val Fragment.backstack: Backstack get() = Navigator.getBackstack(requireActivity())