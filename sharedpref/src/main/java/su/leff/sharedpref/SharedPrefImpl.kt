package su.leff.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SharedPrefImpl(context: Context) : SharedPref {

    private val sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE)

    private fun edit(): SharedPreferences.Editor {
        return sharedPreferences.edit()
    }

    override var accessToken: String
        get() = getString(Constants.ACCESS_TOKEN.name)
        set(value) {
            putString(Constants.ACCESS_TOKEN.name, value)
        }

    override var refreshToken: String
        get() = getString(Constants.REFRESH_TOKEN.name)
        set(value) {
            putString(Constants.REFRESH_TOKEN.name, value)
        }

    private fun putString(key: String, value: String) {
        edit().putString(key, value).apply()
    }

    private fun getString(key: String): String {
        return sharedPreferences.getString(key, error) ?: error
    }

    companion object {
        const val error = "ERROR"
    }
}
