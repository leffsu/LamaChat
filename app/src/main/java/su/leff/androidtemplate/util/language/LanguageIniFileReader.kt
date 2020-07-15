package su.leff.androidtemplate.util.language

import android.content.Context
import su.leff.androidtemplate.R
import su.leff.translator.Translator
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.collections.HashMap

class LanguageIniFileReader(private val context: Context) {

    fun readLanguage(languageState: LanguageState) {
        val hashMap: HashMap<String, String> = when (languageState) {
            LanguageState.RU -> {
                readIniFile(R.raw.ru_text)
            }
            LanguageState.EN -> {
                readIniFile(R.raw.en_text)
            }
        }
        Translator.loadMap(hashMap)
    }

    private fun readIniFile(resource: Int): HashMap<String, String> {
        val properties = Properties()
            .apply {
                load(
                    BufferedReader(
                        InputStreamReader(
                            context.resources.openRawResource(resource),
                            StandardCharsets.UTF_8
                        )
                    )
                )
            }
        return readTranslationsFromProperties(properties)
    }

    /**
     * Properties have specific structure, so we're reading them like this
     */
    private fun readTranslationsFromProperties(properties: Properties): HashMap<String, String> {
        val translations = HashMap<String, String>()
        val props = properties
        for (key in props.stringPropertyNames()) {
            translations[key] = props.getProperty(key, "ERROR")
        }
        return translations
    }
}