package <%= appPackage %>.data.example.room.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.TypeConverters
import <%= appPackage %>.data.example.room.db.mapper.DateConverter
import java.util.*

/**
 * Created by Dwi_Ari on 11/16/17.
 */

class LoanCompleteEntity(
        @ColumnInfo(name = "id")
        val id: String,
        @ColumnInfo(name = "title")
        val bookTitle: String,
        @ColumnInfo(name = "name")
        val userName: String,
        @TypeConverters(DateConverter::class)
        val startTime: Date,
        @TypeConverters(DateConverter::class)
        val endTime: Date
)
