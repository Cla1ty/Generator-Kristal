package <%= appPackage %>.domain.example.raw.interactor

import <%= appPackage %>.domain.example.Example
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.interactor.base.UseCase
import <%= appPackage %>.domain.example.raw.repository.ExampleRepository
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
