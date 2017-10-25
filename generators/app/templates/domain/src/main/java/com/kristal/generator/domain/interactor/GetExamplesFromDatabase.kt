package <%= appPackage %>.domain.interactor

import <%= appPackage %>.domain.Example
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.repository.ExampleDatabaseRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/23/17.
 */

class GetExamplesFromDatabase
@Inject internal constructor(
        private val repo: ExampleDatabaseRepository,
        thread: PostExecutorThread
) : UseCaseSqlBrite<List<Example>, String>(thread) {
    override fun build(params: String?): Observable<List<Example>> =
            repo.examples(params!!)
}
