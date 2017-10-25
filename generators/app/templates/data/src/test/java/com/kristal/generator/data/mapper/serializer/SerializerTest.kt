package <%= appPackage %>.data.mapper.serializer

import <%= appPackage %>.data.entity.ExampleEntity
import <%= appPackage %>.data.entity.ExampleListEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/16/17.
 */

class SerializerTest {
    private lateinit var serializer: Serializer

    private val jsonTest = "{\"data\":[{\"id\":\"a\",\"message\":\"a\"}]}"

    @Before
    fun setUp() {
        serializer = Serializer()
    }

    @Test
    fun serialize() {
        val readData = serializer.deserialize(jsonTest, ExampleListEntity::class.java)
        val newData = serializer.serialize(readData, ExampleListEntity::class.java)

        Assert.assertEquals(jsonTest, newData)
    }

    @Test
    fun deserialize() {
        val data = ExampleListEntity()
        data.data = ArrayList()
        (data.data as ArrayList)
                .add(ExampleEntity()
                        .apply {
                            id = "a"
                            message = "a"
                        })

        val readData = serializer.deserialize(jsonTest, ExampleListEntity::class.java)
        for (i in 0 until (data.data as ArrayList<ExampleEntity>).size) {
            Assert.assertEquals(
                    (data.data as ArrayList<ExampleEntity>)[i].id,
                    readData.data!![i].id)
            Assert.assertEquals(
                    (data.data as ArrayList<ExampleEntity>)[i].message,
                    readData.data!![i].message)
        }
    }

}
