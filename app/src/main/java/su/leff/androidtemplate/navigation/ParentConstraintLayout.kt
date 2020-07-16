package su.leff.androidtemplate.navigation

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintLayout

class ParentConstraintLayout(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int?) :
    ConstraintLayout(context, attributeSet, defStyleAttr ?: 0) {

    constructor(context: Context) : this(context, null, null)

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, null)


    var blocked = false

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (blocked) {
            false
        } else {
            super.onTouchEvent(event)
        }
    }
}