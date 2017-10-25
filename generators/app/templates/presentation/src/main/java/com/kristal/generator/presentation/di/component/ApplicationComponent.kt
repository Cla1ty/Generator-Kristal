package <%= appPackage %>.presentation.di.component

import <%= appPackage %>.presentation.AndroidApplication
import <%= appPackage %>.presentation.di.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/14/17.
 */

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ApplicationModule::class
))
interface ApplicationComponent : AndroidInjector<AndroidApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AndroidApplication>()

}
