package <%= appPackage %>.data.db.entity

import android.content.ContentValues
import android.database.Cursor
import android.text.TextUtils
import <%= appPackage %>.data.db.tools.Db
import java.util.*

/**
 * Created by Dwi_Ari on 10/30/17.
 */

/**
 * Created by Dwi_Ari on 10/28/17.
 */

data class ExampleEntity(
        val kata: String,
        val makna: String,
        val dateCreate: String,
        val dateUpdate: String
) {
    companion object {
        val KATA = "Kata"
        val MAKNA = "Makna"
        val DATE_CREATE = "Datecreate"
        val DATE_UPDATE = "Dateupdate"

        fun contentValues(entity: ExampleEntity): ContentValues =
                ContentValues().apply {
                    put(KATA, entity.kata)
                    put(MAKNA, entity.makna)

                    val date = Calendar.getInstance().time

                    val dateCreate = when (TextUtils.isEmpty(entity.dateCreate)) {
                        true -> date.toString()
                        else -> entity.dateCreate
                    }
                    val dateUpdate = when (TextUtils.isEmpty(entity.dateUpdate)) {
                        true -> date.toString()
                        else -> entity.dateUpdate
                    }
                    put(DATE_CREATE, dateCreate)
                    put(DATE_UPDATE, dateUpdate)
                }

        fun transform(cursor: Cursor): ExampleEntity {
            return ExampleEntity(
                    Db.getString(cursor, KATA)!!,
                    Db.getString(cursor, MAKNA)!!,
                    Db.getString(cursor, DATE_CREATE) ?: "",
                    Db.getString(cursor, DATE_UPDATE) ?: ""
            )
        }
    }
}