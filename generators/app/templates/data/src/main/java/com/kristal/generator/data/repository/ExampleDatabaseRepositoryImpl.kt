package <%= appPackage %>.data.repository

import <%= appPackage %>.data.example.database.db.ExampleTableExternal
import <%= appPackage %>.data.example.file.file.mapper.toExample
import <%= appPackage %>.domain.example.Example
import <%= appPackage %>.domain.example.database.repository.ExampleDatabaseRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/23/17.
 */

@Singleton
class ExampleDatabaseRepositoryImpl
@Inject internal constructor(
        private val table: ExampleTableExternal
) : ExampleDatabaseRepository {
    override fun examples(search: String): Observable<List<Example>> =
            table.search(search).map { it.map { it.toExample() } }
}
