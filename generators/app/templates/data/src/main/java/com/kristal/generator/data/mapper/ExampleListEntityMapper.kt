package <%= appPackage %>.data.mapper

import <%= appPackage %>.data.entity.ExampleListEntity
import <%= appPackage %>.domain.Example
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/13/17.
 */

@Singleton
internal class ExampleListEntityMapper
@Inject internal constructor() {
    fun transform(entity: ExampleListEntity): List<Example> {
        if (entity.data == null)
            throw NullPointerException()

        return entity.data!!
                .map {
                    Example(it.id!!, it.message!!)
                }
    }
}
