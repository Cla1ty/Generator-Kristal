package <%= appPackage %>.domain.install

import <%= appPackage %>.domain.Example
import io.reactivex.Observable

/**
 * Created by Dwi_Ari on 10/22/17.
 */

interface ExampleInstall {
    fun datas(): Observable<List<Example>>
}
