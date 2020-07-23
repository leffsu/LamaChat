package su.leff.androidtemplate.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children

/**
 * Это класс необходим в корне верстки для того, чтобы мы могли на всех экранах показать
 * ProgressBar и заблокировать интерфейс на время выполнения какого-либо действия, т.к. мы не хотим,
 * чтобы юзер, например, мог изменять свои данные на экране авторизации пока идет запрос на
 * авторизацию. Юзкейсы можно придумывать бесконечно, но это необходимо использовать, если
 * выполняется какая-то важная операция.
 */
class ParentConstraintLayout(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int?) :
    ConstraintLayout(context, attributeSet, defStyleAttr ?: 0) {

    constructor(context: Context) : this(context, null, null)

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, null)

    /**
     * Флаг, означающий блокировку интерфейса.
     */
    var blocked = false

    /**
     * Переопределяем касание родителя верстки, чтобы он не мог получать события пока заблокирован.
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (blocked) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    /**
     * Переопределяем касание всем элементам внутри верстки, чтобы на них тоже нельзя было нажимать
     * пока интерфейс заблокирован. Выполняем в onDraw(), т.к. это последний этап создания View.
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (x in children) {
            x.setOnTouchListener { _, _ -> blocked }
        }
    }

}