package <%= appPackage %>.domain.interactor

import <%= appPackage %>.domain.example.database.interactor.GetExamplesFromDatabase
import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.example.database.repository.ExampleDatabaseRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Dwi_Ari on 10/31/17.
 */

@RunWith(MockitoJUnitRunner::class)
class GetExamplesFromDatabaseTest{
    private lateinit var getExample: GetExamplesFromDatabase

    @Mock
    private lateinit var thread: PostExecutorThread
    @Mock
    private lateinit var repo: ExampleDatabaseRepository

    @Before
    fun setUp() {
        getExample = GetExamplesFromDatabase(repo, thread)
    }

    @Test
    fun testGetUserListUseCaseObservableHappyCase() {
        getExample.build("cek")

        Mockito.verify(repo).examples("cek")
        Mockito.verifyNoMoreInteractions(repo)
        Mockito.verifyZeroInteractions(thread)
    }
}