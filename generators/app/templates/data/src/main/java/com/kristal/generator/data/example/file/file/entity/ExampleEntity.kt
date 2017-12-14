package <%= appPackage %>.data.example.file.file.entity

import android.database.Cursor
import com.google.gson.annotations.SerializedName
import <%= appPackage %>.data.example.database.db.ExampleTableExternal
import <%= appPackage %>.data.example.database.db.tools.Db

/**
 * Created by Dwi_Ari on 10/11/17.
 */

data class ExampleEntity(
        @SerializedName("id")
        val id: String,
        @SerializedName("message")
        val message: String
) {
    companion object {
        fun transform(cursor: Cursor): ExampleEntity =
                ExampleEntity(
                    Db.getString(cursor, ExampleTableExternal.ID)!!,
                    Db.getString(cursor, ExampleTableExternal.MESSAGE)!!
                )
    }
}
