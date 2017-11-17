package <%= appPackage %>.domain.interactor

import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.repository.ExampleRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Dwi_Ari on 10/31/17.
 */

@RunWith(MockitoJUnitRunner::class)
class GetExamplesTest {
    private lateinit var getExample: GetExamples

    @Mock
    private lateinit var executor: ThreadExecutor
    @Mock
    private lateinit var thread: PostExecutorThread
    @Mock
    private lateinit var repo: ExampleRepository

    @Before
    fun setUp() {
        getExample = GetExamples(repo, executor, thread)
    }

    @Test
    fun testGetUserListUseCaseObservableHappyCase() {
        getExample.build()

        verify(repo).examples()
        verifyNoMoreInteractions(repo)
        verifyZeroInteractions(thread)
        verifyZeroInteractions(executor)
    }

}