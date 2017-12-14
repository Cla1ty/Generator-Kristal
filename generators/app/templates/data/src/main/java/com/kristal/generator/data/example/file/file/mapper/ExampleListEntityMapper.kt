package <%= appPackage %>.data.example.file.file.mapper

import <%= appPackage %>.data.example.file.file.entity.ExampleListEntity
import <%= appPackage %>.domain.example.Example

/**
 * Created by Dwi_Ari on 10/13/17.
 */

internal fun ExampleListEntity.toListExample(): List<Example> = data
        .map {
            Example(it.id, it.message)
        }