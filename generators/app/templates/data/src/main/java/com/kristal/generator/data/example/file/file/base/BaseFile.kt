package <%= appPackage %>.data.example.file.file.base

import android.content.Context
import <%= appPackage %>.data.example.file.file.tools.FileManager
import <%= appPackage %>.domain.executor.ThreadExecutor
import java.io.File

/**
 * Created by Dwi_Ari on 10/13/17.
 */

abstract class BaseFile
internal constructor(
        private val context: Context,
        private val fileManager: FileManager,
        private val threadExecutor: ThreadExecutor,
        private val fileName: String
) {
    private val cacheDir = context.cacheDir

    private val cacheName = "last_cache_update"
    private val cacheKeyTimeMilis = "${cacheName}_time_milis"
    private val cacheKeyVersion = "${cacheName}_version"

    protected fun buildFile(id: Int): File {
        val builder = StringBuilder()
                .append(cacheDir.path)
                .append(File.separator)
                .append(fileName)
                .append(id)
        return File(builder.toString())
    }

    protected fun setLastCacheUpdateTimeMilis() {
        fileManager.writeToPreferences(context,
                fileName + cacheName,
                cacheKeyTimeMilis,
                System.currentTimeMillis())
    }

    protected fun getLastCacheUpdateTimeMilis(): Long =
            fileManager.getFromPreferences(context,
                    fileName + cacheName,
                    cacheKeyTimeMilis)

    protected fun setLastCacheUpdateVersion(version: Long) {
        fileManager.writeToPreferences(context,
                fileName + cacheName,
                cacheKeyVersion,
                version)
    }

    protected fun getLastCacheUpdateVersion(): Long =
            fileManager.getFromPreferences(context,
                    fileName + cacheName,
                    cacheKeyTimeMilis)

    protected fun evict() {
        executeAsynchronously(CacheEvictor(fileManager, cacheDir))
    }

    protected fun executeAsynchronously(runnable: Runnable) {
        threadExecutor.execute(runnable)
    }

    internal class CacheWriter(
            private val fileManager: FileManager,
            private val file: File,
            private val content: String
    ) : Runnable {
        override fun run() {
            fileManager.writeToFile(file, content)
        }
    }

    internal class CacheEvictor(
            private val fileManager: FileManager,
            private val cacheDir: File
    ) : Runnable {
        override fun run() {
            fileManager.clearDirectory(cacheDir)
        }
    }
}
