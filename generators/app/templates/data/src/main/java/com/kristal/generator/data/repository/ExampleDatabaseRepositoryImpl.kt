package <%= appPackage %>.data.repository

import <%= appPackage %>.data.db.ExampleTable
import <%= appPackage %>.data.mapper.ExampleEntityMapper
import <%= appPackage %>.domain.Example
import <%= appPackage %>.domain.repository.ExampleDatabaseRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/23/17.
 */

@Singleton
class ExampleDatabaseRepositoryImpl
@Inject internal constructor(
        private val table:ExampleTable,
        private val mapper: ExampleEntityMapper
) : ExampleDatabaseRepository{
    override fun examples(search: String): Observable<List<Example>>  =
            table.search(search).map { it.map { mapper.transform(it) } }
}
