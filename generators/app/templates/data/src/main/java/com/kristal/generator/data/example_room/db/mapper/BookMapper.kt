package <%= appPackage %>.data.example_room.db.mapper

import <%= appPackage %>.data.example_room.db.entity.BookEntity
import <%= appPackage %>.domain.example_room.Book

/**
 * Created by Dwi_Ari on 11/17/17.
 */

fun BookEntity.toBook(): Book = Book(id, title)