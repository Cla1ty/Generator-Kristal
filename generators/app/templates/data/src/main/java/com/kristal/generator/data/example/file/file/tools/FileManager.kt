package <%= appPackage %>.data.example.file.file.tools

import android.content.Context
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/11/17.
 */

@Singleton
internal class FileManager
@Inject internal constructor() {
    fun writeToFile(file: File, content: String) {
        if (file.exists()) return

        FileWriter(file).apply {
            write(content)
            close()
        }
    }

    fun readFileContent(file: File): String {
        if (!file.exists()) return ""

        val builder = StringBuilder()
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)

        var stringLine = bufferedReader.readLine()
        while (stringLine != null) {
            builder.append(stringLine).append("\n")
            stringLine = bufferedReader.readLine()
        }
        bufferedReader.close()
        fileReader.close()

        return builder.toString()
    }

    fun exists(file: File): Boolean = file.exists()

    fun clearDirectory(dir: File): Boolean {
        var result = false
        if (dir.exists()) {
            for (file in dir.listFiles()) {
                result = file.delete()
            }
        }
        return result
    }

    fun writeToPreferences(content: Context, preferencesName: String, key: String, value: Long) {
        content.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
                .edit()
                .putLong(key, value)
                .apply()
    }

    fun getFromPreferences(content: Context, preferencesName: String, key: String): Long =
            content.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
                    .getLong(key, 0)
}
