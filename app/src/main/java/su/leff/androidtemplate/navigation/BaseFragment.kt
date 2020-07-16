package su.leff.androidtemplate.navigation

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
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

    private fun initSpinner(parentView: View) {

        if (parentView is ParentConstraintLayout) {
            parent = parentView
            val spinner = layoutInflater.inflate(R.layout.element_progressbar, null)
            spinner.id = View.generateViewId()
            val layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )

            if (parentView.id == -1) {
                parentView.id = View.generateViewId()
            }
            parentView.addView(
                spinner, layoutParams
            )
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

    fun showProgress() {
        cvSpinner.show()
        parent.blocked = true
    }

    fun hideProgress() {
        cvSpinner.hide()
        parent.blocked = true
    }

    fun <T : BaseKey> getKey(): T = requireArguments.getParcelable<T>("KEY")!!
}