package <%= appPackage %>.data.raw

import android.util.Log
import <%= appPackage %>.data.ApplicationTestCase
import <%= appPackage %>.data.file.mapper.serializer.Serializer
import <%= appPackage %>.data.raw.tools.RawManager
import org.junit.Before
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/16/17.
 */

class ExampleRawImplTest :ApplicationTestCase(){
    private lateinit var raw: RawManager
    private val serializer = Serializer()
    private lateinit var impl: ExampleRawImpl

    @Before
    fun setUp() {
        raw = RawManager(context)
        impl = ExampleRawImpl(raw, serializer)
    }

    @Test
    fun alphabetEntityList() {
        impl.alphabetEntityList()
                .subscribe(
                        {
                            Log.d("Trace", "Next")
                            for (i in it.data!!) {
                                Log.d("Trace", "Data " + i.id)
                            }
                        },
                        {
                            Log.d("Trace", "Error ${it.message}")
                        },
                        {
                            Log.d("Trace", "Complete")
                        }
                )
    }

}
