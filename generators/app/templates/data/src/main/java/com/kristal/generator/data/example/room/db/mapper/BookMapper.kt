package <%= appPackage %>.data.example.room.db.mapper

import <%= appPackage %>.data.example.room.db.entity.BookEntity
import <%= appPackage %>.domain.example.room.Book

/**
 * Created by Dwi_Ari on 11/17/17.
 */

fun BookEntity.toBook(): Book = Book(id, title)