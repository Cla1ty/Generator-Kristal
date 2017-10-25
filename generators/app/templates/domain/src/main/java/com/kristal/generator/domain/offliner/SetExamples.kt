package <%= appPackage %>.domain.offliner

import <%= appPackage %>.domain.install.ExampleInstall
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
