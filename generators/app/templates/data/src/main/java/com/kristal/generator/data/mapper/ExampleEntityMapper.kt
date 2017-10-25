package <%= appPackage %>.data.mapper

import android.content.ContentValues
import <%= appPackage %>.data.db.ExampleTable
import <%= appPackage %>.data.entity.ExampleEntity
import <%= appPackage %>.domain.Example
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/13/17.
 */

@Singleton
internal class ExampleEntityMapper
@Inject internal constructor() {
    fun transform(entity: ExampleEntity): Example = Example(entity.id!!, entity.message!!)

    fun transform(example: Example): ExampleEntity = ExampleEntity()
            .apply {
                id = example.id
                message = example.message
            }

    fun transform2ContentValue(entity: ExampleEntity) =
            ContentValues().apply {
                put(ExampleTable.ID, entity.id)
                put(ExampleTable.MESSAGE, entity.message)
            }
}