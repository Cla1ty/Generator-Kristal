package <%= appPackage %>.presentation.di.module

import <%= appPackage %>.presentation.di.module.base.EmptyModule
import <%= appPackage %>.presentation.view.activity.HomeActivity
import <%= appPackage %>.presentation.view.activity.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Dwi_Ari on 10/14/17.
 */

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(EmptyModule::class))
    internal abstract fun bindMain(): SplashActivity

    @ContributesAndroidInjector(modules = arrayOf(EmptyModule::class))
    internal abstract fun bindHome(): HomeActivity
}
