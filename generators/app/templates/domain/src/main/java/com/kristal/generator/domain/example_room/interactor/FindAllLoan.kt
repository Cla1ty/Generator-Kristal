package <%= appPackage %>.domain.example_room.interactor

import <%= appPackage %>.domain.example_room.LoanComplete
import <%= appPackage %>.domain.example_room.repository.LoanRepository
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.interactor.base.UseCaseFlowable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class FindAllLoan
@Inject internal constructor(
        private val repo: LoanRepository,
        executor: ThreadExecutor,
        postExecutor: PostExecutorThread
) : UseCaseFlowable<List<LoanComplete>, Void>(executor, postExecutor) {
    override fun build(params: Void?): Flowable<List<LoanComplete>> = repo.findAllLoan()
}