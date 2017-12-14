package <%= appPackage %>.tool.log

import android.app.Application
import android.content.Context
import org.jetbrains.annotations.TestOnly

/**
 * Created by Dwi_Ari on 10/15/17.
 */

object Logger {

    internal var printer: Printer? = null

    fun install(application: Application) {
        printer = Printer(application.packageName, Logger::class.java)
    }

    @TestOnly
    fun install(context: Context) {
        printer = Printer(context.packageName, Logger::class.java)
    }
}

fun printTree() {
    Logger.printer?.root()
}

fun printMethod(fileName: String) {
    Logger.printer?.lifecycle(fileName)
}

fun verbose(any: Any) {
    Logger.printer?.printToSystem(Printer.VERBOSE, any)
}

fun debug(any: Any) {
    Logger.printer?.printToSystem(Printer.DEBUG, any)
}

fun info(any: Any) {
    Logger.printer?.printToSystem(Printer.INFO, any)
}

fun warm(any: Any) {
    Logger.printer?.printToSystem(Printer.WARM, any)
}

fun err(any: Any) {
    Logger.printer?.printToSystem(Printer.ERROR, any)
}

fun assert(any: Any) {
    Logger.printer?.printToSystem(Printer.ASSERT, any)
}
