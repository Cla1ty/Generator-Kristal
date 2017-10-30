package <%= appPackage %>.domain.interactor

import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.interactor.base.UseCase
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Dwi_Ari on 10/16/17.
 */

@RunWith(MockitoJUnitRunner::class)
class UseCaseTest {
    private lateinit var useCase: UseCaseTestClass

    @Mock
    private lateinit var executor: ThreadExecutor
    @Mock
    private lateinit var thread: PostExecutorThread

    @Before
    fun setUp() {

    }

    @Test
    fun build() {

    }

    @Test
    fun execute() {

    }

    @Test
    fun dispose() {

    }

    private class UseCaseTestClass(
            executor: ThreadExecutor,
            thread: PostExecutorThread
    ) : UseCase<Any, Unit>(executor, thread) {
        override fun build(params: Unit?): Observable<Any> =
                Observable.empty()
    }

}
