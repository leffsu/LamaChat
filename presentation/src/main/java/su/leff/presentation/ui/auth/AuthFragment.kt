package su.leff.presentation.ui.auth

import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_auth.*
import su.leff.presentation.navigation.BaseFragment
import su.leff.presentation.ui.home.HomeKey
import su.leff.presentation.util.backstack
import su.leff.presentation.util.language.LanguageState
import su.leff.presentation.util.onClick
import su.leff.presentation.BuildConfig
import su.leff.presentation.R
import su.leff.presentation.entity.DialogPresentation
import su.leff.presentation.util.hide
import su.leff.presentation.util.show
import su.leff.translator.Translator
import su.leff.translator.Translator.hintKey
import su.leff.translator.Translator.key
import kotlin.random.Random

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

        setupTitleSpan()
        setupListeners()
    }

    private fun setupTitleSpan() {
        /*
        Здесь подписываемся на смену языка в translationViewModel потому что мы ставим
        Spannable, а у него в разных языках разные значения начала и конца для подсветки текста.
        */
        translationViewModel.language.observe(viewLifecycleOwner, Observer { state ->

            txvLanguage.text = state.name

            val welcomeMessage = Translator.getString("welcome")
            val spannable = SpannableString(welcomeMessage)

            var start = 0
            var end = 0
            when (state) {
                LanguageState.EN -> {
                    start = 11
                    end = 19
                }
                LanguageState.RU -> {
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
    }

    private fun setupListeners() {

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

        // При нажатии на кнопку выбора языков, показать диалог с языками.
        btnLanguage.onClick {
            showBottomDialog()
        }

        btnLogin.onClick {
            login()
        }

        edtPassword.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                login()
            }
            false
        }
    }

    private fun login() {
        showProgress()

        Handler().postDelayed({
            hideProgress()
            backstack.goTo(HomeKey())
        }, 5000)
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
            translationViewModel.language.value ?: LanguageState.EN,
            this::setNewLanguageState
        )
        fragment.show(childFragmentManager, "")
    }
}