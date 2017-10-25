package <%= appPackage %>.tool.log

import android.os.Looper
import android.util.Log

/**
 * Created by Dwi_Ari on 10/24/17.
 */

internal class Printer(
        private val packageName: String,
        private val limit: Class<*>) {
    private var processTime = 0L

    fun generateTrace(data: Data) {
        val stackTrace = Throwable().stackTrace

        data.source = stackTrace[0]
        data.parent = stackTrace[0]

        var setSource = false

        for (trace in stackTrace) {
            if (!trace.className.contains(packageName)) break
            data.parent = trace

            if (trace.className.contains(limit.name)) {
                setSource = true
            } else if (setSource) {
                setSource = false
                data.source = trace
            }
        }

        data.link = ".${data.source.methodName}(${data.source.fileName}:${data.source.lineNumber})"
        data.fileName = data.parent.fileName.split('.')[0]
    }

    fun print(level: Int, value: Data.() -> Unit) {
        val data = Data()

        value(data)
        generateTrace(data)

        when {
            data.messages != null -> {
                for (i in 0 until data.messages!!.size) {
                    if (i == 0) {
                        data.message = "===== ${data.messages!![i].toUpperCase()} ====="
                    } else {
                        data.message += "\n${data.messages!![i]}"
                    }
                }
                data.message += "\n===== end ====="
            }
            data.any != null -> {
                data.message = "===== ${data.any!!.javaClass.simpleName.toUpperCase()} ====="
                for (lField in data.any!!.javaClass.declaredFields) {
                    if (lField.name == "\$change" || lField.name == "serialVersionUID")
                        continue

                    lField.isAccessible = true
                    data.message += "\n" + lField.name + " : " + lField.get(data.any)
                }
                data.message += "\n===== end ====="
            }
        }

        when (level) {
            VERBOSE -> {
                when (data.throwable == null) {
                    true -> Log.v(TAG_DEFAULT, "${data.message} ${data.link}")
                    else -> Log.v(TAG_DEFAULT, "${data.message} ${data.link}", data.throwable)
                }
            }
            DEBUG -> {
                when (data.throwable == null) {
                    true -> Log.d(TAG_DEFAULT, "${data.message} ${data.link}")
                    else -> Log.d(TAG_DEFAULT, "${data.message} ${data.link}", data.throwable)
                }
            }
            INFO -> {
                when (data.throwable == null) {
                    true -> Log.i(TAG_DEFAULT, "${data.message} ${data.link}")
                    else -> Log.i(TAG_DEFAULT, "${data.message} ${data.link}", data.throwable)
                }
            }
            WARM -> {
                when (data.throwable == null) {
                    true -> Log.w(TAG_DEFAULT, "${data.message} ${data.link}")
                    else -> Log.w(TAG_DEFAULT, "${data.message} ${data.link}", data.throwable)
                }
            }
        }
    }

    fun root() {
        val stackTrace = Throwable().stackTrace
        for (trace in stackTrace) {
            if (!trace.className.contains(packageName!!)) return
            val link = ".${trace.methodName}(${trace.fileName}:${trace.lineNumber})"
            Log.d(TAG_DEFAULT, link + "\n" + toString())
        }
    }

    fun lifecycle(fileName: String) {
        var second = System.currentTimeMillis() - processTime
        val data = Data()
        val mainThread = when (Looper.myLooper() == Looper.getMainLooper()) {
            true -> "Main Thread"
            else -> "Worker Thread"
        }

        processTime = System.currentTimeMillis()
        if (second > 5000) {
            second = 0
        }

        generateTrace(data)

        Log.d(TAG_LIFE_CYCLE, "$mainThread: $fileName ${data.link}: $second ms")
    }


    class Data {
        var message: String = ""
        var messages: List<String>? = null
        var throwable: Throwable? = null
        var any: Any? = null

        internal lateinit var source: StackTraceElement
        internal lateinit var parent: StackTraceElement

        internal lateinit var link: String
        internal lateinit var fileName: String
    }

    companion object {
        private val TAG_DEFAULT = "Trace"
        private val TAG_LIFE_CYCLE = "LifeCycle"

        val VERBOSE = 1
        val DEBUG = 2
        val INFO = 3
        val WARM = 4
    }
}
