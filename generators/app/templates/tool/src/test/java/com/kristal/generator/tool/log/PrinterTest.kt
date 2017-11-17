package <%= appPackage %>.tool.log

import org.junit.Before
import org.junit.Test

/**
 * Created by Dwi_Ari on 10/30/17.
 */
class PrinterTest {
    private lateinit var printer: Printer
    @Before
    fun setup() {
        printer = Printer("", PrinterTest::class.java)
    }

    @Test
    fun string() {
        val data = Printer.Data()
        printer.getMessage("INI STRING", data)
        println(data.message)
    }

    @Test
    fun throuable() {
        val data = Printer.Data()
        printer.getMessage(Throwable("Ini Throwable"), data)
        println(data.message)
    }

    @Test
    fun any() {
        val data = Printer.Data()
        val data2 = Data("Nama", "Message")
        printer.getMessage(data2, data)
        println(data.message)
    }

    class Data(val name:String, val message:String)

}