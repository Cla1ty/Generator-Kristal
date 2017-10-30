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

    private fun generateTrace(data: Data) {
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

    fun getMessage(any: Any, data: Data) {
        generateTrace(data)

        when (any) {
            is String -> {
                data.message = any
            }
            is List<*> -> {
                for (i in 0 until any.size) {
                    if (i == 0) {
                        data.message = "===== ${any[i].toString().toUpperCase()} ====="
                    } else {
                        data.message += "\n${any[i]}"
                    }
                }
                data.message += "\n===== end ====="
            }
            is Throwable -> {
                data.message = any.message!!
                data.throwable = any
            }
            else -> {
                data.message = "===== ${any.javaClass.simpleName.toUpperCase()} ====="
                for (field in any.javaClass.declaredFields) {
                    if (field.name == "\$change" || field.name == "serialVersionUID")
                        continue

                    field.isAccessible = true
                    data.message += "\n" + field.name + " : " + field.get(any)
                }
                data.message += "\n===== end ====="
            }
        }

        data.message += " ${data.link}"
    }

    fun printToSystem(level: Int, any: Any) {

        val data = Data()
        getMessage(any, data)

        when (level) {
            VERBOSE -> {
                when (data.throwable == null) {
                    true -> Log.v(TAG_DEFAULT, data.message)
                    else -> Log.v(TAG_DEFAULT, data.message, data.throwable)
                }
            }
            DEBUG -> {
                when (data.throwable == null) {
                    true -> Log.d(TAG_DEFAULT, data.message)
                    else -> Log.d(TAG_DEFAULT, data.message, data.throwable)
                }
            }
            INFO -> {
                when (data.throwable == null) {
                    true -> Log.i(TAG_DEFAULT, data.message)
                    else -> Log.i(TAG_DEFAULT, data.message, data.throwable)
                }
            }
            WARM -> {
                when (data.throwable == null) {
                    true -> Log.w(TAG_DEFAULT, data.message)
                    else -> Log.w(TAG_DEFAULT, data.message, data.throwable)
                }
            }
            ERROR -> {
                when (data.throwable == null) {
                    true -> Log.e(TAG_DEFAULT, data.message)
                    else -> Log.e(TAG_DEFAULT, data.message, data.throwable)
                }
            }
            ASSERT -> {
                when (data.throwable == null) {
                    true -> Log.wtf(TAG_DEFAULT, data.message)
                    else -> Log.wtf(TAG_DEFAULT, data.message, data.throwable)
                }
            }
        }
    }

    fun root() {
        val stackTrace = Throwable().stackTrace
        for (trace in stackTrace) {
            if (!trace.className.contains(packageName)) return
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
        var message = ""
        var throwable: Throwable? = null

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
        val ERROR = 5
        val ASSERT = 6
    }
}
