package <%= appPackage %>.presentation.di.module

import android.content.Context
import <%= appPackage %>.data.example.room.db.RoomModule
import <%= appPackage %>.data.executor.JobExecutor
import <%= appPackage %>.data.example.file.file.ExampleFile
import <%= appPackage %>.data.example.file.file.ExampleFileImpl
import <%= appPackage %>.data.example.raw.raw.ExampleRaw
import <%= appPackage %>.data.example.raw.raw.ExampleRawImpl
import <%= appPackage %>.data.repository.ExampleDatabaseRepositoryImpl
import <%= appPackage %>.data.repository.ExamplePreferencenRepositoryImpl
import <%= appPackage %>.data.repository.ExampleRepositoryImpl
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.repository.ApplicationRepository
import <%= appPackage %>.domain.example.database.repository.ExampleDatabaseRepository
import <%= appPackage %>.domain.example.raw.repository.ExampleRepository
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
        RoomModule::class
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
