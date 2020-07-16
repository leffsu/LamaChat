package su.leff.androidtemplate.navigation

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.children
import androidx.fragment.app.Fragment
import su.leff.androidtemplate.R
import su.leff.androidtemplate.app.App
import su.leff.androidtemplate.util.hide
import su.leff.androidtemplate.util.requireArguments
import su.leff.androidtemplate.util.show
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

        // Определяем, верна ли верстка.
        if (parentView is ParentConstraintLayout) {
            parent = parentView
            val spinner = layoutInflater.inflate(R.layout.element_progressbar, null)
            // Генерируем id потому что Constraint требует.
            spinner.id = View.generateViewId()
            val layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            if (parentView.id == -1) {
                parentView.id = View.generateViewId()
            }
            for (child in parentView.children) {
                if (child.id == -1) {
                    child.id = View.generateViewId()
                }
            }
            // Добавляем наш прогрессбар в дерево.
            parentView.addView(
                spinner, layoutParams
            )

            // Определяем позицию прогрессбара.
            val constraintSet = ConstraintSet()

            constraintSet.clone(parentView)
            constraintSet.centerHorizontally(spinner.id, ConstraintSet.PARENT_ID)
            constraintSet.centerVertically(spinner.id, ConstraintSet.PARENT_ID)
            constraintSet.applyTo(parentView)

            cvSpinner = spinner as ConstraintLayout
        } else {
            throw RuntimeException("Parent is not ParentConstraintLayout")
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
}