package <%= appPackage %>.data.raw

import <%= appPackage %>.data.file.entity.ExampleListEntity
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/13/17.
 */

interface ExampleRaw {
    fun alphabetEntityList(): Observable<ExampleListEntity>
}
