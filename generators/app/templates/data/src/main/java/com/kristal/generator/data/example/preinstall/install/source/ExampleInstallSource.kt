package <%= appPackage %>.data.example.preinstall.install.source

import <%= appPackage %>.data.example.file.file.entity.ExampleListEntity
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/22/17.
 */

internal interface ExampleInstallSource {
    fun examples(): Observable<ExampleListEntity>
}
