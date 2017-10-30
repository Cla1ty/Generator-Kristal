package <%= appPackage %>.data.db

import android.database.sqlite.SQLiteDatabase
import <%= appPackage %>.data.db.entity.ExampleEntity
import <%= appPackage %>.data.db.source.ExampleHelper
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/28/17.
 */

internal class ExampleTable
@Inject constructor(
        private val helper: ExampleHelper
) {
    fun allData(): Observable<List<ExampleEntity>> =
            helper.getDatabase().createQuery(TABLE, "SELECT * FROM $TABLE ORDER BY ${ExampleEntity.DATE_UPDATE} DESC")
                    .mapToList { ExampleEntity.transform(it) }

    fun anyData(entity: ExampleEntity): Observable<Boolean> =
            helper.getDatabase().createQuery(TABLE, "SELECT COUNT(*) FROM $TABLE WHERE ${ExampleEntity.KATA} == ?", entity.kata)
                    .mapToOne { it.getInt(0) >= 1 }

    fun insert(entity: ExampleEntity) {
        helper.getDatabase().insert(TABLE, ExampleEntity.contentValues(entity), SQLiteDatabase.CONFLICT_REPLACE)
    }

    fun delete(entity: ExampleEntity) {
        helper.getDatabase().delete(TABLE, "${ExampleEntity.KATA} == ?", entity.kata)
    }

    companion object {
        val TABLE = "favourite"
    }
}