package <%= appPackage %>.domain.example.room.repository

import <%= appPackage %>.domain.example.room.Book
import io.reactivex.Flowable

/**
 * Created by Dwi_Ari on 11/17/17.
 */

interface BookRepository {
    fun loadUserById(id: Int): Book
    fun findBooksBorrowedByName(username: String): Flowable<List<Book>>
}
