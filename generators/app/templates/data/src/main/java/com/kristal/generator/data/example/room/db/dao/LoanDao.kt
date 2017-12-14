package <%= appPackage %>.data.example.room.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.ABORT
import android.arch.persistence.room.Query
import android.arch.persistence.room.TypeConverters
import <%= appPackage %>.data.example.room.db.entity.LoanCompleteEntity
import <%= appPackage %>.data.example.room.db.entity.LoanEntity
import <%= appPackage %>.data.example.room.db.mapper.DateConverter
import io.reactivex.Flowable
import java.util.*

/**
 * Created by Dwi_Ari on 11/16/17.
 */

@Dao
@TypeConverters(DateConverter::class)
interface LoanDao {
    @Query("SELECT * From Loan")
    fun findAll(): Flowable<List<LoanEntity>>

    @Query("SELECT Loan.id, Book.title, User.name, Loan.startTime, Loan.endTime From Loan " +
            "INNER JOIN Book ON Loan.book_id = Book.id " +
            "INNER JOIN User ON Loan.user_id = User.id ")
    fun findAllWithUserAndBook(): Flowable<List<LoanCompleteEntity>>

    @Query("SELECT Loan.id, Book.title as title, User.name as name, Loan.startTime, Loan.endTime " +
            "FROM Book " +
            "INNER JOIN Loan ON Loan.book_id = Book.id " +
            "INNER JOIN User on User.id = Loan.user_id " +
            "WHERE User.name LIKE :userName " +
            "AND Loan.endTime > :after ")
    fun findLoansByNameAfter(userName: String, after: Date): Flowable<List<LoanCompleteEntity>>

    @Insert(onConflict = ABORT)
    fun insertLoan(loan: LoanEntity)

    @Query("DELETE FROM Loan")
    fun deleteAll()
}
