package <%= appPackage %>.domain

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/16/17.
 */

class ExampleTest {

    private lateinit var example: Example

    @Before
    fun setUp() {
        example = Example(FAKE_USER_ID, "")
    }

    @Test
    fun testAlphabet(){
        val id = example.id

        Assertions.assertThat(id).isEqualTo(FAKE_USER_ID)
    }

    companion object {
        val FAKE_USER_ID = "a"
    }
}
