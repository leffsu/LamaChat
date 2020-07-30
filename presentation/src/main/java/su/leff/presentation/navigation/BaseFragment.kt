package su.leff.presentation.navigation

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.children
import androidx.fragment.app.Fragment
import su.leff.presentation.R
import su.leff.presentation.di.fragment.DaggerFragmentComponent
import su.leff.presentation.di.fragment.FragmentComponent
import su.leff.presentation.di.fragment.FragmentModule
import su.leff.presentation.util.hide
import su.leff.presentation.util.requireArguments
import su.leff.presentation.util.show
import su.leff.presentation.view.ParentConstraintLayout
import su.leff.presentation.viewmodel.ChatViewModel
import su.leff.presentation.viewmodel.TranslationViewModel
import javax.inject.Inject

open class BaseFragment (
) : Fragment() {

    @Inject
    lateinit var translationViewModel: TranslationViewModel

    @Inject
    lateinit var chatViewModel: ChatViewModel

    private val component: FragmentComponent by lazy {
        DaggerFragmentComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()
    }

    private lateinit var cvSpinner: ConstraintLayout
    private lateinit var parent: ParentConstraintLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner(view)
    }

    /**
     * Функция инициализирует спиннер-прогрессбар, блокирующий интерфейс. Необходима для того, чтобы
     * на любом экране, на котором юзается ParentConstraintLayout (в нашем случае, чтобы было проще,
     * всех).
     * @param parentView - родитель верстки у фрагмента.
     */
    private fun initSpinner(parentView: View) {

        fun throwException() {
//            throw RuntimeException("Parent is not ParentConstraintLayout")
        }

        fun initParentConstraint(constraint: ParentConstraintLayout) {
            // Генерируем id потому что Constraint требует.
            fun generateViewIds() {
                parentView.ensureViewId()
                for (child in constraint.children) {
                    child.ensureViewId()
                }
            }

            parent = constraint
            val spinner = layoutInflater.inflate(R.layout.element_progressbar, null)
            val layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )

            // Добавляем наш прогрессбар в дерево.
            constraint.addView(
                spinner, layoutParams
            )

            generateViewIds()

            // Определяем позицию прогрессбара.
            val constraintSet = ConstraintSet()

            constraintSet.clone(constraint)
            constraintSet.centerHorizontally(spinner.id, ConstraintSet.PARENT_ID)
            constraintSet.centerVertically(spinner.id, ConstraintSet.PARENT_ID)
            constraintSet.applyTo(constraint)

            cvSpinner = spinner as ConstraintLayout
        }


        // Определяем, верна ли верстка.
        if (parentView is ParentConstraintLayout) {
            initParentConstraint(parentView)
        } else {
            throwException()
        }
    }

    /**
     * Функция показывает прогрессбар и блокирует интерфейс.
     */
    fun showProgress() {
        cvSpinner.show()
        parent.blocked = true
    }

    /**
     * Функция прячет прогрессбар и разблокировывает интерфейс.
     */
    fun hideProgress() {
        cvSpinner.hide()
        parent.blocked = false
    }

    fun <T : BaseKey> getKey(): T = requireArguments.getParcelable<T>("KEY")!!

    private fun View.ensureViewId() = run {
        if (this.id == -1) {
            this.id = View.generateViewId()
        }
    }
}