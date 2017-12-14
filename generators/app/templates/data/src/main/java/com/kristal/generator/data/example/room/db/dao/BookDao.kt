package <%= appPackage %>.data.example.room.db.dao

import android.arch.persistence.room.*
import <%= appPackage %>.data.example.room.db.entity.BookEntity
import <%= appPackage %>.data.example.room.db.mapper.DateConverter
import io.reactivex.Flowable
import java.util.*

/**
 * Created by Dwi_Ari on 11/16/17.
 */

@Dao
@TypeConverters(DateConverter::class)
interface BookDao {

    @Query("select * from Book where id = :id")
    fun loadUserById(id: Int): BookEntity

    @Query("SELECT * FROM Book " +
            "INNER JOIN Loan ON Loan.book_id = Book.id " +
            "INNER JOIN User on User.id = Loan.user_id " +
            "WHERE User.name LIKE :userName")
    fun findBooksBorrowedByName(userName: String): Flowable<List<BookEntity>>

    @Query("SELECT * FROM Book " +
            "INNER JOIN Loan ON Loan.book_id = Book.id " +
            "INNER JOIN User on User.id = Loan.user_id " +
            "WHERE User.name LIKE :userName " +
            "AND Loan.endTime > :after ")
    fun findBooksBorrowedByNameAfter(userName: String, after: Date): Flowable<List<BookEntity>>

    @Query("SELECT * FROM Book " +
            "INNER JOIN Loan ON Loan.book_id = Book.id " +
            "INNER JOIN User on User.id = Loan.user_id " +
            "WHERE User.name LIKE :userName")
    fun findBooksBorrowedByNameSync(userName: String): List<BookEntity>

    @Query("SELECT * FROM Book " +
            "INNER JOIN Loan ON Loan.book_id LIKE Book.id " +
            "WHERE Loan.user_id LIKE :userId ")
    fun findBooksBorrowedByUser(userId: String): Flowable<List<BookEntity>>

    @Query("SELECT * FROM Book " +
            "INNER JOIN Loan ON Loan.book_id LIKE Book.id " +
            "WHERE Loan.user_id LIKE :userId " +
            "AND Loan.endTime > :after ")
    fun findBooksBorrowedByUserAfter(userId: String, after: Date): Flowable<List<BookEntity>>

    @Query("SELECT * FROM Book " +
            "INNER JOIN Loan ON Loan.book_id LIKE Book.id " +
            "WHERE Loan.user_id LIKE :userId ")
    fun findBooksBorrowedByUserSync(userId: String): List<BookEntity>

    @Query("SELECT * FROM Book")
    fun findAllBooks(): Flowable<List<BookEntity>>


    @Query("SELECT * FROM Book")
    fun findAllBooksSync(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBook(book: BookEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateBook(book: BookEntity)

    @Query("DELETE FROM Book")
    fun deleteAll()
}
