package <%= appPackage %>.data.repository.source

import <%= appPackage %>.data.file.entity.ExampleListEntity
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/13/17.
 */
internal interface ExampleStore {
    fun alphabetListEntity(): Observable<ExampleListEntity>
}
