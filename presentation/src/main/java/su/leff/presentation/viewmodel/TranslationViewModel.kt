package su.leff.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import su.leff.presentation.util.language.LanguageIniFileReader
import su.leff.presentation.util.language.LanguageState

class TranslationViewModel(private val context: Context) : ViewModel() {

    private val reader = LanguageIniFileReader(context)

    private val languageState = MutableLiveData<LanguageState>()
    val language: LiveData<LanguageState> = languageState

    fun postLanguage(newLanguageState: LanguageState) {
        reader.readLanguage(newLanguageState)
        languageState.postValue(newLanguageState)
    }
}