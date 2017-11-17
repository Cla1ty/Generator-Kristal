package <%= appPackage %>.data.db.mapper

import android.content.ContentValues
import android.database.Cursor
import android.text.TextUtils
import <%= appPackage %>.data.db.entity.ExampleEntity
import <%= appPackage %>.data.db.tools.Db
import java.util.*

/**
 * Created by Dwi_Ari on 11/1/17.
 */

fun ExampleEntity.toContentValues(): ContentValues =
        ContentValues().apply {
            val date = Calendar.getInstance().time

            val dateCreate = when (TextUtils.isEmpty(dateCreate)) {
                true -> date.toString()
                else -> dateCreate
            }
            val dateUpdate = when (TextUtils.isEmpty(dateUpdate)) {
                true -> date.toString()
                else -> dateUpdate
            }

            put(ExampleEntity.KATA, kata)
            put(ExampleEntity.MAKNA, makna)
            put(ExampleEntity.DATE_CREATE, dateCreate)
            put(ExampleEntity.DATE_UPDATE, dateUpdate)
        }

fun Cursor.toExampleEntity(): ExampleEntity = ExampleEntity(
        Db.getString(this, ExampleEntity.KATA)!!,
        Db.getString(this, ExampleEntity.MAKNA)!!,
        Db.getString(this, ExampleEntity.DATE_CREATE) ?: "",
        Db.getString(this, ExampleEntity.DATE_UPDATE) ?: ""
)