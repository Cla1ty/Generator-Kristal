package <%= appPackage %>.domain.interactor.base

import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import java.util.*

/**
 * Created by Dwi_Ari on 10/31/17.
 */

@RunWith(MockitoJUnitRunner::class)
class UseCaseSqlBriteTest {

    private lateinit var useCase: UseCaseTestClass

    @Mock
    private lateinit var mockExecutor: ThreadExecutor
    @Mock
    private lateinit var mockThread: PostExecutorThread

    private var valuesCount = 0

    @Before
    fun setUp() {
        useCase = UseCaseTestClass(mockThread)
        BDDMockito.given(mockThread.getScheduler())
                .willReturn(TestScheduler())
    }

    @Test
    fun testBuildUseCaseObservableReturnCorrectResult() {
        valuesCount = 0
        useCase.execute({
            valuesCount++
        }, {})

        Assertions.assertThat(valuesCount).isZero()
    }

    @Test
    fun testSubscriptionWhenExecutingUseCase() {
        useCase.execute({},{})
        useCase.dispose()

        Assertions.assertThat(useCase.isCompositeDispose()).isTrue()
        Assertions.assertThat(useCase.isDispose()).isTrue()
    }

    @Test
    fun testSubscriptionWhenExecutingUseCase2() {
        useCase.execute({},{})
        useCase.stop()

        Assertions.assertThat(useCase.isDispose()).isTrue()
    }

    private class UseCaseTestClass(
            thread: PostExecutorThread
    ) : UseCaseSqlBrite<Objects, Unit>(thread) {
        override fun build(params: Unit?): Observable<Objects> =
                Observable.empty()
    }
}