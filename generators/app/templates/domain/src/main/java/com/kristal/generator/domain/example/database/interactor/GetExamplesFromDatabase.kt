package <%= appPackage %>.domain.example.database.interactor

import <%= appPackage %>.domain.example.Example
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.interactor.base.UseCaseSqlBrite
import <%= appPackage %>.domain.example.database.repository.ExampleDatabaseRepository
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
