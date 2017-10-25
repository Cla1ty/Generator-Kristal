package <%= appPackage %>.data.repository.source

import <%= appPackage %>.data.file.ExampleFile
import <%= appPackage %>.data.entity.ExampleListEntity
import <%= appPackage %>.data.raw.ExampleRaw
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/13/17.
 */

internal class ExampleSourceRaw(
        private val raw: ExampleRaw,
        private val file: ExampleFile
) : ExampleStore {
    val version: Long = 1

    override fun alphabetListEntity(): Observable<ExampleListEntity> =
            raw.alphabetEntityList().doOnNext { file.put(it, version) }
}
