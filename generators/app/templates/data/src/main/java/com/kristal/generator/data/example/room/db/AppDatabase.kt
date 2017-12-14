package <%= appPackage %>.data.example.room.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import <%= appPackage %>.data.example.room.db.dao.BookDao
import <%= appPackage %>.data.example.room.db.dao.LoanDao
import <%= appPackage %>.data.example.room.db.dao.UserDao
import <%= appPackage %>.data.example.room.db.entity.BookEntity
import <%= appPackage %>.data.example.room.db.entity.LoanEntity
import <%= appPackage %>.data.example.room.db.entity.UserEntity

/**
 * Created by Dwi_Ari on 11/16/17.
 */

@Database(entities = arrayOf(
        UserEntity::class,
        BookEntity::class,
        LoanEntity::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao
    abstract fun loanDao(): LoanDao

    companion object {
        fun getDatabase(context: Context): AppDatabase {
            val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app.db")
                    .build()
            DatabaseInitializer.populateAsync(db)
            return db
        }
    }
}
