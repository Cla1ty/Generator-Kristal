package <%= appPackage %>.data.file.mapper.serializer

import <%= appPackage %>.data.file.entity.ExampleListEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/16/17.
 */

class SerializerTest {
    private lateinit var serializer: Serializer
    private val jsonTest = "{\"data\":[{\"id\":\"ID\",\"message\":\"MESSAGE\"}]}"

    @Before
    fun setUp() {
        serializer = Serializer()
    }

    @Test
    fun serialize() {
        val readData = serializer.deserialize(jsonTest, ExampleListEntity::class.java)
        val newData = serializer.serialize(readData, ExampleListEntity::class.java)

        assertThat(jsonTest).isEqualTo(newData)
    }

    @Test
    fun deserialize() {
        val readData = serializer.deserialize(jsonTest, ExampleListEntity::class.java)

        readData.data.forEach {
            assertThat(it.id).isEqualTo("ID")
            assertThat(it.message).isEqualTo("MESSAGE")
        }
    }

}
