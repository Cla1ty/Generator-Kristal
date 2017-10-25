package <%= appPackage %>.tool

import android.support.test.InstrumentationRegistry
import <%= appPackage %>.tool.log.Logger
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/17/17.
 */


class LoggerTest {
    @Before
    fun setUp() {
        Logger.install(InstrumentationRegistry.getContext())

    }

    @Test
    fun info() {
        Logger.i("Message")

        Assert.assertTrue(true)
    }

}