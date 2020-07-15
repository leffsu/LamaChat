package su.leff.androidtemplate.ui.auth

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_auth.*
import su.leff.androidtemplate.BuildConfig
import su.leff.androidtemplate.R
import su.leff.androidtemplate.navigation.BaseFragment
import su.leff.androidtemplate.util.hide
import su.leff.androidtemplate.util.onClick
import su.leff.androidtemplate.util.show

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AuthFragment : BaseFragment() {

    var currentState = AuthState.SIGN_IN

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txvVersion.text = BuildConfig.VERSION_NAME
        btnLogin.text = "Login"
        btnContactUs.text = "No account?"
        edtEmail.hint = "Email"
        edtPassword.hint = "Password"
        edtLogin.hint = "Login"
        val welcomeMessage = "Welcome to LamaChat"
        val spannable = SpannableString(welcomeMessage)
        spannable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.accent)),
            11,
            19,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        txvWelcomeMessage.setText(spannable, TextView.BufferType.SPANNABLE)

        btnContactUs.onClick {
            when (currentState) {
                AuthState.SIGN_IN -> {
                    currentState = AuthState.SIGN_UP
                    edtLogin.show()
                    btnLogin.text = "Sign up"
                    btnContactUs.text = "Have an account?"
                }

                AuthState.SIGN_UP -> {
                    currentState = AuthState.SIGN_IN
                    edtLogin.hide()
                    btnLogin.text = "Login"
                    btnContactUs.text = "No account?"
                }
            }
        }
    }
}