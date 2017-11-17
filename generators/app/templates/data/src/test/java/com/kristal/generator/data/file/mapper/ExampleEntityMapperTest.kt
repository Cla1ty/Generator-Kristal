package <%= appPackage %>.data.file.mapper

import <%= appPackage %>.data.file.entity.ExampleEntity
import <%= appPackage %>.domain.Example
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/31/17.
 */
class ExampleEntityMapperTest {

    @Test
    fun transform() {
        val data = ExampleEntity("ID", "MESSAGE")
        val dataMap = data.toExample()

        assertThat(dataMap.id).isEqualTo("ID")
        assertThat(dataMap.message).isEqualTo("MESSAGE")
    }

    @Test
    fun transform1() {
        val data = Example("ID", "MESSAGE")
        val dataMap = data.toExampleEntity()

        assertThat(dataMap.id).isEqualTo("ID")
        assertThat(dataMap.message).isEqualTo("MESSAGE")
    }

    @Test
    fun transform2ContentValue() {

    }

}