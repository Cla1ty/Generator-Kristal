package <%= appPackage %>.data

import android.app.Application
import android.content.Context
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.io.File

/**
 * Created by Dwi_Ari on 10/31/17.
 */

@RunWith(RobolectricTestRunner::class)
@Config(
        constants = BuildConfig::class,
        application = Application::class,
        sdk = intArrayOf(21),
        manifest = "src/main/AndroidManifest.xml"
)
abstract class ApplicationTestCase {
    @get:Rule
    var injectMocksRule = TestRule { base, description ->
        MockitoAnnotations.initMocks(this@ApplicationTestCase)
        base
    }

    @Test
    fun testContext() {
        assertThat(context).isNotNull()
    }

    @Test
    fun testCacheDir() {
        assertThat(cacheDir).isNotNull()
    }

    protected val context: Context
        get() = RuntimeEnvironment.application

    protected val cacheDir: File
        get() = RuntimeEnvironment.application.cacheDir
}