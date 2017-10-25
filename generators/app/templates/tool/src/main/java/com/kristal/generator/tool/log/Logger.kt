package <%= appPackage %>.tool.log

import android.app.Application
import android.content.Context
import org.jetbrains.annotations.TestOnly

/**
 * Created by Dwi_Ari on 10/15/17.
 */

object Logger {

    private var printer: Printer? = null

    fun install(application: Application) {
        printer = Printer(application.packageName, Logger::class.java)
    }

    @TestOnly
    fun install(context: Context) {
        printer = Printer(context.packageName, Logger::class.java)
    }

    fun root() {
        printer?.root()
    }

    fun lifecycle(fileName: String) {
        printer?.lifecycle(fileName)
    }

    fun v(message: String) {
        printer?.print(Printer.VERBOSE, {
            this.message = message
        })
    }

    fun v(messages: List<String>) {
        printer?.print(Printer.VERBOSE, {
            this.messages = messages
        })
    }

    fun v(any: Any) {
        printer?.print(Printer.VERBOSE, {
            this.any = any
        })
    }

    fun d(message: String) {
        printer?.print(Printer.DEBUG, {
            this.message = message
        })
    }

    fun d(messages: List<String>) {
        printer?.print(Printer.DEBUG, {
            this.messages = messages
        })
    }

    fun d(any: Any) {
        printer?.print(Printer.DEBUG, {
            this.any = any
        })
    }

    fun i(message: String) {
        printer?.print(Printer.INFO, {
            this.message = message
        })
    }

    fun i(messages: List<String>) {
        printer?.print(Printer.INFO, {
            this.messages = messages
        })
    }

    fun i(any: Any) {
        printer?.print(Printer.INFO, {
            this.any = any
        })
    }

    fun w(message: String) {
        printer?.print(Printer.WARM, {
            this.message = message
        })
    }

    fun w(messages: List<String>) {
        printer?.print(Printer.WARM, {
            this.messages = messages
        })
    }

    fun w(any: Any) {
        printer?.print(Printer.WARM, {
            this.any = any
        })
    }
}
