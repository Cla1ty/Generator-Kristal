package <%= appPackage %>.data.example.preinstall.install

import <%= appPackage %>.data.example.file.file.mapper.toListExample
import <%= appPackage %>.data.example.preinstall.install.source.ExampleInstallFactory
import <%= appPackage %>.domain.example.Example
import <%= appPackage %>.domain.example.preinstall.install.ExampleInstall
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/22/17.
 */

@Singleton
class ExampleInstallImpl
@Inject internal constructor(
        private val factory: ExampleInstallFactory
) : ExampleInstall {
    override fun datas():
            Observable<List<Example>> = factory.create().examples().map { it.toListExample() }
}
