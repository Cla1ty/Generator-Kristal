package <%= appPackage %>.data.example_room.db

import android.content.Context
import <%= appPackage %>.data.example_room.db.dao.BookDao
import <%= appPackage %>.data.example_room.db.dao.LoanDao
import <%= appPackage %>.data.example_room.db.dao.UserDao
import <%= appPackage %>.data.example_room.repository.BookRepositoryImpl
import <%= appPackage %>.data.example_room.repository.LoanRepositoryImpl
import <%= appPackage %>.domain.example_room.repository.BookRepository
import <%= appPackage %>.domain.example_room.repository.LoanRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 11/17/17.
 */

@Module
class RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(context: Context):
            AppDatabase = AppDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun provideBookDao(db: AppDatabase):
            BookDao = db.bookDao()

    @Provides
    @Singleton
    fun provideLoanDao(db: AppDatabase):
            LoanDao = db.loanDao()

    @Provides
    @Singleton
    fun provideUserDao(db: AppDatabase):
            UserDao = db.userDao()

    @Provides
    @Singleton
    fun provideBookRepository(repo: BookRepositoryImpl):
            BookRepository = repo

    @Provides
    @Singleton
    fun provideLoanRepository(repo: LoanRepositoryImpl):
            LoanRepository = repo
}
