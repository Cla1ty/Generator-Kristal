package <%= appPackage %>.domain.interactor.base

import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.TestScheduler
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import java.util.*

/**
 * Created by Dwi_Ari on 10/16/17.
 */

@RunWith(MockitoJUnitRunner::class)
class UseCaseTest {
    private lateinit var useCase: UseCaseTestClass

    private lateinit var observer: DefaultDisposableObserver<Objects>

    @Mock
    private lateinit var mockExecutor: ThreadExecutor
    @Mock
    private lateinit var mockThread: PostExecutorThread

    private var valuesCount = 0

    @Before
    fun setUp() {
        useCase = UseCaseTestClass(mockExecutor, mockThread)
        observer = DefaultDisposableObserver(
                {
                    valuesCount++
                }
        )
        BDDMockito.given(mockThread.getScheduler())
                .willReturn(TestScheduler())
    }

    @Test
    fun testBuildUseCaseObservableReturnCorrectResult() {
        valuesCount = 0
        useCase.execute(observer as DisposableObserver<Any>, null)

        assertThat(valuesCount).isZero()
    }

    @Test
    fun testSubscriptionWhenExecutingUseCase() {
        useCase.execute(observer as DisposableObserver<Any>, null)
        useCase.dispose()

        assertThat(observer.isDisposed).isTrue()
    }

    @Test
    fun testSubscriptionWhenExecutingUseCase2() {
        useCase.execute(observer as DisposableObserver<Any>, null)
        useCase.stop()

        assertThat(observer.isDisposed).isTrue()
    }

    private class UseCaseTestClass(
            executor: ThreadExecutor,
            thread: PostExecutorThread
    ) : UseCase<Any, Unit>(executor, thread) {
        override fun build(params: Unit?): Observable<Any> =
                Observable.empty()
    }

}
