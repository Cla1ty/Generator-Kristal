package <%= appPackage %>.data.example.room.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Dwi_Ari on 11/16/17.
 */

@Entity(tableName = "user")
class UserEntity(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: String,
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "lastName")
        val lastName: String,
        @ColumnInfo(name = "age")
        val age: Int = 0
)
