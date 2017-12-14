package <%= appPackage %>.data.example.database.db

import android.database.sqlite.SQLiteDatabase
import <%= appPackage %>.data.example.database.db.source.ExampleHelperExternal
import <%= appPackage %>.data.example.file.file.entity.ExampleEntity
import <%= appPackage %>.data.example.file.file.mapper.toContentValue
import <%= appPackage %>.data.example.file.file.mapper.toExampleEntity
import <%= appPackage %>.domain.example.Example
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/23/17.
 */


internal class ExampleTableExternal
@Inject constructor(
        private val helper: ExampleHelperExternal
) {
    fun allData(): Observable<List<ExampleEntity>> =
            helper.getDatabase()
                    .createQuery(TABLE, "SELECT * FROM $TABLE")
                    .mapToList { ExampleEntity.transform(it) }

    fun search(search: String): Observable<List<ExampleEntity>> =
            helper.getDatabase()
                    .createQuery(TABLE, "SELECT * FROM $TABLE WHERE $ID LIKE '%$search%'")
                    .mapToList { ExampleEntity.transform(it) }

    fun insert(example: Example) {
        val entity = example.toExampleEntity()
        val cv = entity.toContentValue()
        helper.getDatabase().insert(TABLE, cv, SQLiteDatabase.CONFLICT_REPLACE)
    }

    fun update(example: Example) {
        val entity = example.toExampleEntity()
        val cv = entity.toContentValue()
        helper.getDatabase().update(TABLE, cv, "$ID = ${entity.id}")
    }

    fun delete(id: String) {
        helper.getDatabase().delete(TABLE, "$ID = $id")
    }

    companion object {
        val TABLE = "data"
        val ID = "id"
        val MESSAGE = "message"
    }
}