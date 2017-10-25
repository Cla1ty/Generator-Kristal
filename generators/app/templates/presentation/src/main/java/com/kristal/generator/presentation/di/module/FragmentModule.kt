package <%= appPackage %>.presentation.di.module

import <%= appPackage %>.presentation.di.module.base.EmptyModule
import <%= appPackage %>.presentation.view.fragment.ExampleDatabaseFragment
import <%= appPackage %>.presentation.view.fragment.ExampleFragment
import <%= appPackage %>.presentation.view.fragment.RecyclerViewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Dwi_Ari on 10/14/17.
 */

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector(modules = arrayOf(EmptyModule::class))
    internal abstract fun bindLearning(): ExampleFragment
    @ContributesAndroidInjector(modules = arrayOf(EmptyModule::class))
    internal abstract fun bindED(): ExampleDatabaseFragment
    @ContributesAndroidInjector(modules = arrayOf(EmptyModule::class))
    internal abstract fun bindRV(): RecyclerViewFragment
}
