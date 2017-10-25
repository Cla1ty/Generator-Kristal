package <%= appPackage %>.presentation

import <%= appPackage %>.BuildConfig
import <%= appPackage %>.presentation.di.component.DaggerApplicationComponent
import <%= appPackage %>.tool.MathHelper
import <%= appPackage %>.tool.log.Logger
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Dwi_Ari on 10/14/17.
 */

class AndroidApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? =
            DaggerApplicationComponent.builder().create(this)
                    .apply {
                        inject(this@AndroidApplication)
                    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
            Logger.install(this)
        }

        MathHelper.install(this)
    }
}
