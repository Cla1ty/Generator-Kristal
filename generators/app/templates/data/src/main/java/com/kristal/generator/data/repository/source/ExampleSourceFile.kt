package <%= appPackage %>.data.repository.source

import <%= appPackage %>.data.file.ExampleFile
import <%= appPackage %>.data.entity.ExampleListEntity
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/13/17.
 */

internal class ExampleSourceFile(
        private val exampleFile: ExampleFile
) : ExampleStore {
    override fun alphabetListEntity(): Observable<ExampleListEntity> = exampleFile.get()
}
