package <%= appPackage %>.data.entity

import android.database.Cursor
import com.google.gson.annotations.SerializedName
import <%= appPackage %>.data.db.ExampleTable
import <%= appPackage %>.data.db.tools.Db

/**
 * Created by Dwi_Ari on 10/11/17.
 */

class ExampleEntity {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("message")
    var message: String? = null

    companion object {
        fun transform(cursor: Cursor): ExampleEntity =
                ExampleEntity().apply {
                    id = Db.getString(cursor, ExampleTable.ID)
                    message = Db.getString(cursor, ExampleTable.MESSAGE)
                }
    }
}
