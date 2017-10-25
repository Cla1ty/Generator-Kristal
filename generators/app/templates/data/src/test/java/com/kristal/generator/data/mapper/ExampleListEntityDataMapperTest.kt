package <%= appPackage %>.data.mapper

import <%= appPackage %>.data.entity.ExampleEntity
import <%= appPackage %>.data.entity.ExampleListEntity
import <%= appPackage %>.domain.Example
import org.junit.Assert
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/16/17.
 */
class ExampleListEntityDataMapperTest {
    private val mapper = ExampleListEntityMapper()

    @Test
    fun transform() {
        val data = ExampleListEntity()
        data.data = ArrayList()
        (data.data as ArrayList)
                .add(ExampleEntity()
                        .apply {
                            id = "a"
                            message = "a"
                        })

        val newData = ArrayList<Example>()
        newData.add(Example("a", "a"))

        val dataMap = mapper.transform(data)

        for (i in 0 until newData.size -1){
            Assert.assertEquals(
                    dataMap[i].id,
                    newData[i].id)
            Assert.assertEquals(
                    dataMap[i].message,
                    newData[i].message)
        }
    }

}
