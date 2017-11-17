package <%= appPackage %>.data.file

import <%= appPackage %>.data.file.entity.ExampleListEntity
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/11/17.
 */

interface ExampleFile {
    fun get(): Observable<ExampleListEntity>
    fun put(data: ExampleListEntity, version: Long)
    fun isCache(): Boolean
    fun version(): Long
    fun evictAll()

}
