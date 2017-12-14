package <%= appPackage %>.data.example.raw.raw

import <%= appPackage %>.data.example.file.file.entity.ExampleListEntity
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/13/17.
 */

interface ExampleRaw {
    fun alphabetEntityList(): Observable<ExampleListEntity>
}
