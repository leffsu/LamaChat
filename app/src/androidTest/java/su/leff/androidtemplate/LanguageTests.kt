package su.leff.androidtemplate

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import su.leff.core.util.language.LanguageIniFileReader
import su.leff.core.util.language.LanguageState

@RunWith(AndroidJUnit4::class)
class LanguageTests {
    /**
     * Тест проверяет консистентность иников для переводов.
     * Он завалится, если какой-то ключ есть в одном переводе, но его нет в другом.
     */
    @Test
    fun ini_consistency() {

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val reader = LanguageIniFileReader(appContext)

        val russian = Translation("russian", reader.readLanguage(LanguageState.RU))
        val english = Translation("english", reader.readLanguage(LanguageState.EN))

        checkHashMapConsistency(listOf(russian, english))
    }

    private fun checkHashMapConsistency(translations: List<Translation>) {
        for (map in translations) {
            // Убираем сам перевод из списка для проверки, чтобы не проверять самого себя.
            val listWithoutThisMap = ArrayList(translations).apply {
                remove(map)
            }

            // Идем по ключам этого перевода.
            for (key in map.hashMap.keys) {
                // Идем по всем остальным переводам.
                for (otherMap in listWithoutThisMap) {
                    // Проверяем, есть ли такой ключ.
                    Assert.assertNotNull(
                        "No key \"$key\" in \"${map.name}\"",
                        otherMap.hashMap[key]
                    )
                }
            }
        }
    }

    // Класс для проверки, нужен, чтобы вывести название перевода, в котором не хватает ключей.
    data class Translation(val name: String, val hashMap: HashMap<String, String>)
}