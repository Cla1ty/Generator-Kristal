package <%= appPackage %>.data.repository.source

import <%= appPackage %>.data.file.ExampleFile
import <%= appPackage %>.data.raw.ExampleRaw
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
class ExampleSourceRawTest {
    private lateinit var source: ExampleSourceRaw

    @Mock
    lateinit var raw: ExampleRaw
    @Mock
    lateinit var file: ExampleFile

    @Before
    fun setUp() {
        source = ExampleSourceRaw(raw, file)
    }

    @Test
    fun alphabetListEntity() {
        source.alphabetListEntity()
        Mockito.verify(raw).alphabetEntityList()
    }

}