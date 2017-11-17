package <%= appPackage %>.data.install.source

import <%= appPackage %>.data.file.entity.ExampleListEntity
import <%= appPackage %>.data.raw.ExampleRaw
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/22/17.
 */

internal class ExampleInstallRaw(
        private val raw: ExampleRaw
) : ExampleInstallSource {
    override fun examples(): Observable<ExampleListEntity> = raw.alphabetEntityList()
}