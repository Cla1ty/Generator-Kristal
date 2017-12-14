package <%= appPackage %>.data.example.preinstall.install.source

import <%= appPackage %>.data.example.raw.raw.ExampleRaw
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/22/17.
 */

@Singleton
internal class ExampleInstallFactory
@Inject internal constructor(
        private val raw: ExampleRaw
) {
    fun create(): ExampleInstallSource = ExampleInstallRaw(raw)
}
