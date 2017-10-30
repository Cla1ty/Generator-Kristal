package <%= appPackage %>.domain.interactor

import <%= appPackage %>.domain.Example
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.interactor.base.UseCase
import <%= appPackage %>.domain.repository.ExampleRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/13/17.
 */

class GetExamples
@Inject internal constructor(
        private val repo: ExampleRepository,
        executor: ThreadExecutor,
        postExecutor: PostExecutorThread
) : UseCase<List<Example>, Void>(executor, postExecutor) {
    override fun build(params: Void?): Observable<List<Example>> = repo.examples()
}
