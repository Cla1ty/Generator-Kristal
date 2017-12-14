package <%= appPackage %>.presentation.example.room.mapper

import <%= appPackage %>.domain.example.room.Book
import <%= appPackage %>.presentation.example.room.model.BookModel

/**
 * Created by Dwi_Ari on 11/17/17.
 */

fun Book.toBookModel():
        BookModel = BookModel(id, title)
