package <%= appPackage %>.data.example.database.db.source

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import <%= appPackage %>.data.example.database.db.ExampleTable
import <%= appPackage %>.data.example.database.db.entity.ExampleEntity
import <%= appPackage %>.data.example.database.db.tools.SqlBriteHelper
import com.squareup.sqlbrite2.BriteDatabase
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/30/17.
 */

class ExampleHelper
@Inject internal constructor(
        context: Context,
        private val helper: SqlBriteHelper
) : SQLiteOpenHelper(context, "Data", null, 1) {
    private val CREATE_FAVOURITE =
            "CREATE TABLE ${ExampleTable.TABLE} (" +
                    "${ExampleEntity.KATA} TEXT NOT NULL," +
                    "${ExampleEntity.MAKNA} TEXT NOT NULL," +
                    "${ExampleEntity.DATE_CREATE} DATE NOT NULL," +
                    "${ExampleEntity.DATE_UPDATE} DATE NOT NULL" +
                    ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_FAVOURITE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + ExampleTable.TABLE)
        onCreate(db)
    }

    fun getDatabase(): BriteDatabase =
            helper.getDatabase(this)
}