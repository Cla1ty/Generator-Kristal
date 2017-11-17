package <%= appPackage %>.data.file.mapper

import <%= appPackage %>.data.file.entity.ExampleListEntity
import <%= appPackage %>.domain.Example

/**
 * Created by Dwi_Ari on 10/13/17.
 */

internal fun ExampleListEntity.toListExample(): List<Example> = data
        .map {
            Example(it.id, it.message)
        }