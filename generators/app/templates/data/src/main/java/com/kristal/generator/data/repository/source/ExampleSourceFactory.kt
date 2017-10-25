package <%= appPackage %>.data.repository.source

import <%= appPackage %>.data.file.ExampleFile
import <%= appPackage %>.data.raw.ExampleRaw
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/13/17.
 */

@Singleton
internal class ExampleSourceFactory
@Inject internal constructor(
        private val file: ExampleFile,
        private val raw: ExampleRaw
) {
    fun create(): ExampleStore {
        val dataStore: ExampleStore = ExampleSourceRaw(raw, file)
        val version = (dataStore as ExampleSourceRaw).version

        return dataStore
//        return when (cache.isCache() && cache.version() >= version) {
//            true -> AlphabetDataStoreDisk(cache)
//            else -> dataStore
//        }
    }
}
