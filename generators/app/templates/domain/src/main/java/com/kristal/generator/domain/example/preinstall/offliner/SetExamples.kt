package <%= appPackage %>.domain.example.preinstall.offliner

import <%= appPackage %>.domain.example.preinstall.install.ExampleInstall
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/22/17.
 */

class SetExamples
@Inject internal constructor(
        private val install: ExampleInstall
) {
    fun execute() = install.datas()
}
