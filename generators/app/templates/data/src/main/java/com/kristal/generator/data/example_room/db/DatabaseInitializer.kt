/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package <%= appPackage %>.data.example_room.db

import android.os.AsyncTask
import android.util.Log
import <%= appPackage %>.data.example_room.db.entity.BookEntity
import <%= appPackage %>.data.example_room.db.entity.LoanEntity
import <%= appPackage %>.data.example_room.db.entity.UserEntity
import java.util.*

object DatabaseInitializer {
    // Simulate a blocking operation delaying each Loan insertion with a delay:
    private val DELAY_MILLIS = 500

    fun populateAsync(db: AppDatabase) {
        PopulateDbAsync(db).execute()
    }

    private fun addLoan(
            db: AppDatabase,
            id: String,
            user: UserEntity,
            book: BookEntity,
            from: Date,
            to: Date
    ): LoanEntity = LoanEntity(id, from, to, book.id, user.id)
            .apply { db.loanDao().insertLoan(this) }

    private fun addBook(
            db: AppDatabase,
            id: String,
            title: String
    ): BookEntity = BookEntity(id, title)
            .apply { db.bookDao().insertBook(this) }

    private fun addUser(
            db: AppDatabase,
            id: String,
            name: String,
            lastName: String,
            age: Int
    ): UserEntity = UserEntity(id, name, lastName, age)
            .apply { db.userDao().insertUser(this) }

    private fun populateWithTestData(db: AppDatabase) {
        db.loanDao().deleteAll()
        db.userDao().deleteAll()
        db.bookDao().deleteAll()

        val user1 = addUser(db, "1", "Jason", "Seaver", 40)
        val user2 = addUser(db, "2", "Mike", "Seaver", 12)
        addUser(db, "3", "Carol", "Seaver", 15)

        val book1 = addBook(db, "1", "Dune")
        val book2 = addBook(db, "2", "1984")
        val book3 = addBook(db, "3", "The War of the Worlds")
        val book4 = addBook(db, "4", "Brave New World")
        addBook(db, "5", "Foundation")
        try {
            // Loans are added with a delay, to have time for the UI to react to changes.

            val today = getTodayPlusDays(0)
            val yesterday = getTodayPlusDays(-1)
            val twoDaysAgo = getTodayPlusDays(-2)
            val lastWeek = getTodayPlusDays(-7)
            val twoWeeksAgo = getTodayPlusDays(-14)

            addLoan(db, "1", user1, book1, twoWeeksAgo, lastWeek)
            Thread.sleep(DELAY_MILLIS.toLong())
            addLoan(db, "2", user2, book1, lastWeek, yesterday)
            Thread.sleep(DELAY_MILLIS.toLong())
            addLoan(db, "3", user2, book2, lastWeek, today)
            Thread.sleep(DELAY_MILLIS.toLong())
            addLoan(db, "4", user2, book3, lastWeek, twoDaysAgo)
            Thread.sleep(DELAY_MILLIS.toLong())
            addLoan(db, "5", user2, book4, lastWeek, today)
            Log.d("DB", "Added loans")

        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    private fun getTodayPlusDays(daysAgo: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DATE, daysAgo)
        return calendar.time
    }

    private class PopulateDbAsync internal constructor(private val mDb: AppDatabase) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void): Void? {
            populateWithTestData(mDb)
            return null
        }

    }
}
