package <%= appPackage %>.data.install.source

import <%= appPackage %>.data.raw.ExampleRaw
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
