package <%= appPackage %>.data.example_room.repository

import <%= appPackage %>.data.example_room.db.dao.BookDao
import <%= appPackage %>.data.example_room.db.mapper.toBook
import <%= appPackage %>.domain.example_room.Book
import <%= appPackage %>.domain.example_room.repository.BookRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class BookRepositoryImpl
@Inject constructor(
        private val dao: BookDao
) : BookRepository {
    override fun loadUserById(id: Int):
            Book = dao.loadUserById(id).toBook()

    override fun findBooksBorrowedByName(username: String):
            Flowable<List<Book>> = dao.findBooksBorrowedByName(username).map { it.map { it.toBook() } }
}
