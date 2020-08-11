package su.leff.presentation.ui.home.subview.core

import android.content.Context

interface SubViewWithListParent<T> {
    fun onItemClick(t: T)
    val context: Context?
}