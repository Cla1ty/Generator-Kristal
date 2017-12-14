package <%= appPackage %>.data.example.file.file.mapper

import android.content.ContentValues
import <%= appPackage %>.data.example.database.db.ExampleTableExternal
import <%= appPackage %>.data.example.file.file.entity.ExampleEntity
import <%= appPackage %>.domain.example.Example

/**
 * Created by Dwi_Ari on 10/13/17.
 */

internal fun ExampleEntity.toExample(): Example = Example(id, message)
internal fun Example.toExampleEntity(): ExampleEntity = ExampleEntity(id, message)
internal fun ExampleEntity.toContentValue() = ContentValues()
        .apply {
            put(ExampleTableExternal.ID, id)
            put(ExampleTableExternal.MESSAGE, message)
        }