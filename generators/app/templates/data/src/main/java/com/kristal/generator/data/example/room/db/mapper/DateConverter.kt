package <%= appPackage %>.data.example.room.db.mapper

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Created by Dwi_Ari on 11/16/17.
 */

class DateConverter {
    @TypeConverter
    fun toDate(timestamp: Long?): Date? = timestamp?.let { Date(it) }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? = date?.time
}
