package su.leff.androidtemplate.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import su.leff.androidtemplate.util.language.LanguageIniFileReader
import su.leff.androidtemplate.util.language.LanguageState
import su.leff.database.entity.note.Note

class TranslationViewModel(private val context: Context) : ViewModel() {

    private val reader = LanguageIniFileReader(context)

    private val languageState = MutableLiveData<LanguageState>()
    val language: LiveData<LanguageState> = languageState

    fun postLanguage(newLanguageState: LanguageState) {
        reader.readLanguage(newLanguageState)
        languageState.postValue(newLanguageState)
    }
}