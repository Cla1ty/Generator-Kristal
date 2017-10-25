package <%= appPackage %>.domain.repository

import <%= appPackage %>.domain.Example
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/23/17.
 */

interface ExampleDatabaseRepository {
    fun examples(search: String): Observable<List<Example>>
}