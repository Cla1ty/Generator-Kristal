package <%= appPackage %>.data.db

import android.database.sqlite.SQLiteDatabase
import <%= appPackage %>.data.db.source.ExampleHelperExternal
import <%= appPackage %>.data.entity.ExampleEntity
import <%= appPackage %>.data.mapper.ExampleEntityMapper
import <%= appPackage %>.domain.Example
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/23/17.
 */


internal class ExampleTableExternal
@Inject constructor(
        private val helper: ExampleHelperExternal,
        private val mapper: ExampleEntityMapper
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
        val entity = mapper.transform(example)
        val cv = mapper.transform2ContentValue(entity)
        helper.getDatabase().insert(TABLE, cv, SQLiteDatabase.CONFLICT_REPLACE)
    }

    fun update(example: Example) {
        val entity = mapper.transform(example)
        val cv = mapper.transform2ContentValue(entity)
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