package su.leff.androidtemplate.navigation

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.children
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import su.leff.androidtemplate.R
import su.leff.androidtemplate.app.App
import su.leff.androidtemplate.util.hide
import su.leff.androidtemplate.util.requireArguments
import su.leff.androidtemplate.util.show
import su.leff.androidtemplate.view.ParentConstraintLayout
import su.leff.androidtemplate.viewmodel.NoteViewModel
import su.leff.androidtemplate.viewmodel.TranslationViewModel
import su.leff.database.AppDatabase
import su.leff.sharedpref.SharedPref
import java.lang.RuntimeException

open class BaseFragment : Fragment() {


    protected lateinit var database: AppDatabase
    protected lateinit var noteViewModel: NoteViewModel
    protected lateinit var sharedPref: SharedPref
    protected lateinit var translationViewModel: TranslationViewModel
    private lateinit var cvSpinner: ConstraintLayout
    private lateinit var parent: ParentConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = (requireActivity().application as App)
        database = app.database
        noteViewModel = app.noteViewModel
        sharedPref = app.sharedPref
        translationViewModel = app.translationViewModel
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
            throw RuntimeException("Parent is not ParentConstraintLayout")
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