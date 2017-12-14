package <%= appPackage %>.data.example.file.file

import android.content.Context
import <%= appPackage %>.data.example.file.file.base.BaseFile
import <%= appPackage %>.data.example.file.file.entity.ExampleListEntity
import <%= appPackage %>.data.example.file.file.mapper.serializer.Serializer
import <%= appPackage %>.data.example.file.file.tools.FileManager
import <%= appPackage %>.data.exception.NotFoundException
import <%= appPackage %>.domain.executor.ThreadExecutor
import io.reactivex.Observable
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/11/17.
 */

@Singleton
class ExampleFileImpl
@Inject internal constructor(
        context: Context,
        private val serializer: Serializer,
        private val fileManager: FileManager,
        threadExecutor: ThreadExecutor
) : BaseFile(context, fileManager, threadExecutor, "alphabet_list_e"), ExampleFile {
    override fun get(): Observable<ExampleListEntity> =
            Observable
                    .create {
                        val file: File = buildFile(0)
                        val content: String = fileManager.readFileContent(file)
                        val example: ExampleListEntity? = serializer.deserialize(content, ExampleListEntity::class.java)

                        it.onComplete()
                        if (example != null) {
                            it.onNext(example)
                        } else {
                            it.onError(NotFoundException())
                        }
                    }

    override fun put(data: ExampleListEntity, version: Long) {
        val file: File = buildFile(0)
        if (!isCache()) {
            val json: String = serializer.serialize(data, ExampleListEntity::class.java)
            executeAsynchronously(CacheWriter(fileManager, file, json))
            setLastCacheUpdateVersion(version)
        }
    }

    override fun isCache(): Boolean = fileManager.exists(buildFile(0))

    override fun version(): Long = getLastCacheUpdateVersion()

    override fun evictAll() {
        this.evict()
    }
}
