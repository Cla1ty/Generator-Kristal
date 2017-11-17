package <%= appPackage %>.data.file.mapper

import <%= appPackage %>.data.file.entity.ExampleEntity
import <%= appPackage %>.data.file.entity.ExampleListEntity
import org.assertj.core.api.Assertions
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/16/17.
 */
class ExampleListEntityMapperTest {

    @Test
    fun transform() {
        val data = ExampleListEntity(
                listOf(ExampleEntity("ID", "MESSAGE"))
        )
        data.toListExample().forEach {
            Assertions.assertThat(it.id).isEqualTo("ID")
            Assertions.assertThat(it.message).isEqualTo("MESSAGE")
        }
    }

}
