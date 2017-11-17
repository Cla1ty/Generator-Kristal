package <%= appPackage %>.presentation.example_room.mapper

import <%= appPackage %>.domain.example_room.Book
import <%= appPackage %>.presentation.example_room.model.BookModel

/**
 * Created by Dwi_Ari on 11/17/17.
 */

fun Book.toBookModel():
        BookModel = BookModel(id, title)
