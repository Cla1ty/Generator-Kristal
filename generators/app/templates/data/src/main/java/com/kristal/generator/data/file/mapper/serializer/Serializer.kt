package <%= appPackage %>.data.file.mapper.serializer

import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/13/17.
 */

@Singleton
internal class Serializer
@Inject internal constructor() {
    private val gson = Gson()

    fun <T> serialize(obj: Any, clazz: Class<T>): String = gson.toJson(obj, clazz)
    fun <T> deserialize(string: String, clazz: Class<T>): T = gson.fromJson(string, clazz)
}
