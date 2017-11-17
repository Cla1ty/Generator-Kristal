package <%= appPackage %>.data.example_room.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Dwi_Ari on 11/16/17.
 */

@Entity(tableName = "book")
data class BookEntity(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: String,
        @ColumnInfo(name = "title")
        val title: String
)
