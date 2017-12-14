package <%= appPackage %>.data.example.raw.raw

import android.util.Log
import <%= appPackage %>.data.ApplicationTestCase
import <%= appPackage %>.data.R
import <%= appPackage %>.data.example.raw.raw.tools.RawManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/16/17.
 */

class RawManagerTest :ApplicationTestCase(){
    private lateinit var raw: RawManager

    private val realData = "{\n" +
            "    \"data\": [\n" +
            "        {\"id\" : \"a\", \"message\" : \"a\"},\n" +
            "        {\"id\" : \"b\", \"message\" : \"b\"},\n" +
            "        {\"id\" : \"c\", \"message\" : \"c\"},\n" +
            "        {\"id\" : \"d\", \"message\" : \"d\"},\n" +
            "        {\"id\" : \"e\", \"message\" : \"e\"},\n" +
            "        {\"id\" : \"f\", \"message\" : \"f\"},\n" +
            "        {\"id\" : \"g\", \"message\" : \"g\"},\n" +
            "        {\"id\" : \"h\", \"message\" : \"h\"},\n" +
            "        {\"id\" : \"i\", \"message\" : \"i\"},\n" +
            "        {\"id\" : \"j\", \"message\" : \"j\"},\n" +
            "        {\"id\" : \"k\", \"message\" : \"k\"},\n" +
            "        {\"id\" : \"l\", \"message\" : \"l\"},\n" +
            "        {\"id\" : \"m\", \"message\" : \"m\"},\n" +
            "        {\"id\" : \"n\", \"message\" : \"n\"},\n" +
            "        {\"id\" : \"o\", \"message\" : \"o\"},\n" +
            "        {\"id\" : \"p\", \"message\" : \"p\"},\n" +
            "        {\"id\" : \"q\", \"message\" : \"q\"},\n" +
            "        {\"id\" : \"r\", \"message\" : \"r\"},\n" +
            "        {\"id\" : \"s\", \"message\" : \"s\"},\n" +
            "        {\"id\" : \"t\", \"message\" : \"t\"},\n" +
            "        {\"id\" : \"u\", \"message\" : \"u\"},\n" +
            "        {\"id\" : \"v\", \"message\" : \"v\"},\n" +
            "        {\"id\" : \"w\", \"message\" : \"w\"},\n" +
            "        {\"id\" : \"x\", \"message\" : \"x\"},\n" +
            "        {\"id\" : \"y\", \"message\" : \"y\"},\n" +
            "        {\"id\" : \"z\", \"message\" : \"z\"}\n" +
            "    ]\n" +
            "}"

    @Before
    fun setUp() {
        raw = RawManager(context)
    }

    @Test
    fun cekRaw(){
        Assert.assertNotNull(raw)
    }

    @Test
    fun readRawContent() {
        val readData = raw.readRawContent(R.raw.data_install)
        Log.d("TRACE", "Content " + readData)
        Log.d("TRACE", "Content " + realData)
        Assert.assertEquals(readData, realData)
    }

    @Test
    fun readEmptyFile(){
        val readData = raw.readRawContent(R.raw.data_kosong)
        Log.d("TRACE", "Content " + readData)
        Assert.assertEquals(readData, null)
    }
}
