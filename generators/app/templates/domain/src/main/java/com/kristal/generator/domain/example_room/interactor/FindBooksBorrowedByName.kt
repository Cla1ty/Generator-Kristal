package <%= appPackage %>.domain.example_room.interactor

import <%= appPackage %>.domain.example_room.Book
import <%= appPackage %>.domain.example_room.repository.BookRepository
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.interactor.base.UseCaseFlowable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class FindBooksBorrowedByName
@Inject internal constructor(
        private val repo: BookRepository,
        executor: ThreadExecutor,
        postExecutor: PostExecutorThread
) : UseCaseFlowable<List<Book>, String>(executor, postExecutor) {
    override fun build(params: String?): Flowable<List<Book>> = repo.findBooksBorrowedByName(params!!)
}