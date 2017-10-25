package <%= appPackage %>.presentation.di.module

import android.content.Context
import <%= appPackage %>.data.executor.JobExecutor
import <%= appPackage %>.data.file.ExampleFile
import <%= appPackage %>.data.file.ExampleFileImpl
import <%= appPackage %>.data.net.tools.NetworkModule
import <%= appPackage %>.data.raw.ExampleRaw
import <%= appPackage %>.data.raw.ExampleRawImpl
import <%= appPackage %>.data.repository.ExampleDatabaseRepositoryImpl
import <%= appPackage %>.data.repository.ExamplePreferencenRepositoryImpl
import <%= appPackage %>.data.repository.ExampleRepositoryImpl
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.repository.ApplicationRepository
import <%= appPackage %>.domain.repository.ExampleDatabaseRepository
import <%= appPackage %>.domain.repository.ExampleRepository
import <%= appPackage %>.presentation.AndroidApplication
import <%= appPackage %>.presentation.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/14/17.
 */

@Module(includes = arrayOf(
        ActivityModule::class,
        FragmentModule::class,
        ProviderModule::class,
        ReceiverModule::class,
        ServiceModule::class,
        NetworkModule::class
))
class ApplicationModule {
    @Provides
    @Singleton
    fun provideApplicationContext(application: AndroidApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideThreadExecutor(executor: JobExecutor): ThreadExecutor = executor

    @Provides
    @Singleton
    fun providePostExecutorThread(thread: UIThread): PostExecutorThread = thread

    @Provides
    @Singleton
    fun provideAlphabetCache(file: ExampleFileImpl): ExampleFile = file

    @Provides
    @Singleton
    fun provideAlphabetRaw(raw: ExampleRawImpl): ExampleRaw = raw

    @Provides
    @Singleton
    fun provideAlphabetRepository(repo: ExampleRepositoryImpl): ExampleRepository = repo

    @Provides
    @Singleton
    fun provideExampleDatabase(repo: ExampleDatabaseRepositoryImpl): ExampleDatabaseRepository = repo

    @Provides
    @Singleton
    fun provideApplicationRepository(repo: ExamplePreferencenRepositoryImpl): ApplicationRepository = repo
}
