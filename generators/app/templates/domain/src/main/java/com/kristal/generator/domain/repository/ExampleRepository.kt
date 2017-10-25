package <%= appPackage %>.domain.repository

import <%= appPackage %>.domain.Example
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/11/17.
 */

interface ExampleRepository {
    fun examples(): Observable<List<Example>>
}
