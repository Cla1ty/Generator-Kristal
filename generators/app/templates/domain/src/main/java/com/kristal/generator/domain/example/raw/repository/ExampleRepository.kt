package <%= appPackage %>.domain.example.raw.repository

import <%= appPackage %>.domain.example.Example
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/11/17.
 */

interface ExampleRepository {
    fun examples(): Observable<List<Example>>
}
