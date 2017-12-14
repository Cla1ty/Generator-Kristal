package <%= appPackage %>.data.example.preinstall.install.source

import <%= appPackage %>.data.example.file.file.entity.ExampleListEntity
import <%= appPackage %>.data.example.raw.raw.ExampleRaw
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/22/17.
 */

internal class ExampleInstallRaw(
        private val raw: ExampleRaw
) : ExampleInstallSource {
    override fun examples(): Observable<ExampleListEntity> = raw.alphabetEntityList()
}