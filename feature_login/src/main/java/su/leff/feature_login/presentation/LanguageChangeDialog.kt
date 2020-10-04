package su.leff.feature_login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_auth_language.*
import su.leff.core.util.language.LanguageState
import su.leff.feature_login.R


/**
 * Диалог, показываемый юзеру при изначальном выборе языка.
 * @param languageState - текущее состояние языка.
 * @param changeLanguage - функция для смены языка.
 */
class LanguageChangeDialog(
    private var languageState: LanguageState,
    private val changeLanguage: (l: LanguageState) -> Unit
) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_auth_language, container, false)
    }

    /**
     * Функция для изменения состояния выбора языка (еще не применённого).
     * Нельзя просто сделать animateLayoutChanges потому что диалог улетает вверх (лол).
     * @param languageState - новое состояние.
     */
    private fun setState(languageState: LanguageState) {
        when (languageState) {
            LanguageState.RU -> {
                elementRussian.imgCheck.animate().alpha(1.0f).duration = 100
                elementEnglish.imgCheck.animate().alpha(0f).duration = 100
            }
            LanguageState.EN -> {
                elementRussian.imgCheck.animate().alpha(0f).duration = 100
                elementEnglish.imgCheck.animate().alpha(1.0f).duration = 100
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txvLanguage.key = "language"

        elementRussian.imgFlag.setImageResource(R.drawable.ic_russian_flag)
        elementRussian.txvLanguageName.key = "russian"

        elementEnglish.imgFlag.setImageResource(R.drawable.ic_english_flag)
        elementEnglish.txvLanguageName.key = "english"

        btnCancel.key = "cancel"
        btnApply.key = "apply"

        setState(languageState)

        // Нажали на кнопку русского языка.
        elementRussian.onClick {
            languageState = LanguageState.RU
            setState(languageState)
        }

        // Нажали на кнопку английского языка.
        elementEnglish.onClick {
            languageState = LanguageState.EN
            setState(languageState)
        }

        // Скрытие диалога по нажатию на кнопку.
        btnCancel.onClick {
            dismiss()
        }

        // Смена языка по нажатию на кнопку "Подтвердить".
        btnApply.onClick {
            changeLanguage(languageState)
            dismiss()
        }
    }


    companion object {
        const val TAG = "ActionBottomDialog"
        fun newInstance(
            languageState: LanguageState,
            changeLanguage: (l: LanguageState) -> Unit
        ): LanguageChangeDialog {
            return LanguageChangeDialog(languageState, changeLanguage)
        }
    }
}