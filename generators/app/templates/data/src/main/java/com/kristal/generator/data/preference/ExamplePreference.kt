package <%= appPackage %>.data.preference

import android.content.Context
import android.content.SharedPreferences
import <%= appPackage %>.domain.repository.ApplicationRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/19/17.
 */

@Singleton
internal class ExamplePreference
@Inject internal constructor(context: Context) {
    private val pref_name = "Application_Pref"

    private val key_language = "language_key"

    private val sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    var language: Int
        get() = sharedPreferences.getInt(key_language, ApplicationRepository.NONE)
        set(value) {
            editor.putInt(key_language, value)
            editor.commit()
        }

    init {
        sharedPreferences = context.getSharedPreferences(pref_name, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }
}
