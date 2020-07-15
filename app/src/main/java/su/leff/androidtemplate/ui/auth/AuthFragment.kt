package su.leff.androidtemplate.ui.auth

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_auth.*
import su.leff.androidtemplate.BuildConfig
import su.leff.androidtemplate.R
import su.leff.androidtemplate.navigation.BaseFragment
import su.leff.androidtemplate.util.hide
import su.leff.androidtemplate.util.language.LanguageState
import su.leff.androidtemplate.util.onClick
import su.leff.androidtemplate.util.show
import su.leff.translator.Translator
import su.leff.translator.Translator.hintKey
import su.leff.translator.Translator.key

/**
 * Фрагмент для авторизации.
 */
class AuthFragment : BaseFragment() {

    private var currentState = AuthState.SIGN_IN

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Указываем версию приложения.
        txvVersion.text = BuildConfig.VERSION_NAME

        // Указываем ключи для текстов при смене языка.
        btnLogin.key = "login"
        btnChangeAuthState.key = "no_account"
        edtEmail.hintKey = "email"
        edtPassword.hintKey = "password"
        edtLogin.hintKey = "username"

        /*
        Здесь подписываемся на смену языка в translationViewModel потому что мы ставим
        Spannable, а у него в разных языках разные значения начала и конца для подсветки текста.
         */
        translationViewModel.language.observe(viewLifecycleOwner, Observer { state ->
            val welcomeMessage = Translator.getString("welcome")
            val spannable = SpannableString(welcomeMessage)

            var start = 0
            var end = 0
            when (state) {
                LanguageState.ENGLISH -> {
                    start = 11
                    end = 19
                }
                LanguageState.RUSSIAN -> {
                    start = 19
                    end = 27
                }
            }

            spannable.setSpan(
                ForegroundColorSpan(resources.getColor(R.color.accent)),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            txvWelcomeMessage.setText(spannable, TextView.BufferType.SPANNABLE)
        })


        // При нажатии на кнопку выбора языков, показать диалог с языками.
        btnLanguage.onClick {
            showBottomDialog()
        }

        // При нажатии на кнопку "Нет аккаунта?" или "Есть аккаунт?" меняем состояние экрана.
        btnChangeAuthState.onClick {
            when (currentState) {
                AuthState.SIGN_IN -> {
                    // Если были на авторизации, то показываем поле логина и меняем пару ключей.
                    currentState = AuthState.SIGN_UP
                    edtLogin.show()
                    btnLogin.key = "signup"
                    btnChangeAuthState.key = "have_an_account"
                }

                AuthState.SIGN_UP -> {
                    // Если были на регистрации, то прячем поле логина.
                    currentState = AuthState.SIGN_IN
                    edtLogin.hide()
                    btnLogin.key = "login"
                    btnChangeAuthState.key = "no_account"
                }
            }
        }
    }

    /**
     * Функция, пробрасываемая в диалог для смены языка, чтобы не городить интерфейс.
     * @param languageState - новый язык.
     */
    private fun setNewLanguageState(languageState: LanguageState) {
        translationViewModel.postLanguage(languageState)
    }

    /**
     * Функция для показа нижнего диалога выбора языка.
     */
    private fun showBottomDialog() {
        val fragment = LanguageChangeDialog.newInstance(
            translationViewModel.language.value ?: LanguageState.ENGLISH,
            this::setNewLanguageState
        )
        fragment.show(childFragmentManager, "")
    }
}