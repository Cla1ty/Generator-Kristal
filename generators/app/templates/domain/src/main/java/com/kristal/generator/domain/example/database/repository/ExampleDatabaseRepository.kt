package <%= appPackage %>.domain.example.database.repository

import <%= appPackage %>.domain.example.Example
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/23/17.
 */

interface ExampleDatabaseRepository {
    fun examples(search: String): Observable<List<Example>>
}