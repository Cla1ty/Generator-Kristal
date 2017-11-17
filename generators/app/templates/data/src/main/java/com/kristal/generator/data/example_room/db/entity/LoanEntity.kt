package <%= appPackage %>.data.example_room.db.entity

import android.arch.persistence.room.*
import <%= appPackage %>.data.example_room.db.mapper.DateConverter
import java.util.*

/**
 * Created by Dwi_Ari on 11/16/17.
 */

@Entity(tableName = "loan",
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = BookEntity::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("book_id")),
                ForeignKey(
                        entity = UserEntity::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("user_id"))
        ))
@TypeConverters(DateConverter::class)
class LoanEntity(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: String,
        @ColumnInfo(name = "startTime")
        val startTime: Date,
        @ColumnInfo(name = "endTime")
        val endTime: Date,
        @ColumnInfo(name = "book_id")
        val bookId: String,
        @ColumnInfo(name = "user_id")
        val userId: String
)
