package <%= appPackage %>.data.install.source

import <%= appPackage %>.data.file.entity.ExampleListEntity
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/22/17.
 */

internal interface ExampleInstallSource {
    fun examples(): Observable<ExampleListEntity>
}
