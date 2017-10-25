package <%= appPackage %>.tool

import org.junit.Assert
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/17/17.
 */

class MathHelperTest {
    @Test
    fun randomInt() {
        val min = 0
        val max = 10

        for (i in 0 until 10000) {
            val random: Int = MathHelper.random(min, max)
            Assert.assertTrue(random in min..max)
            Assert.assertFalse(random < min || random > max)
        }
    }

    @Test
    fun randomFloat() {
        val min = 0f
        val max = 1f

        for (i in 0 until 10000) {
            val random: Float = MathHelper.random(min, max)
            Assert.assertTrue(random in min..max)
            Assert.assertFalse(random < min || random > max)
        }
    }

    @Test
    fun randomList() {
        val list = arrayListOf(1,2,3,4,5)

        for (i in 0 until 10000){
            val random = MathHelper.random(list)
            val same = (0 until list.size).none { list[it] != random[it] }

            Assert.assertEquals(list.size, random.size)
            Assert.assertFalse(same)
            Assert.assertTrue(random.containsAll(list))
        }
    }

}