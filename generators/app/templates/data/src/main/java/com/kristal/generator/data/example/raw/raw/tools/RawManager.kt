package <%= appPackage %>.data.example.raw.raw.tools

import android.content.Context
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/13/17.
 */

@Singleton
internal class RawManager
@Inject internal constructor(private val context: Context) {
    fun readRawContent(rawId: Int): String? {
        var content: String? = null
        val streamer: InputStream = context.resources.openRawResource(rawId)
        val reader = BufferedReader(InputStreamReader(streamer))
        var line = reader.readLine()

        while (line != null) {
            if (content == null) {
                content = line
            } else {
                content += "\n$line"
            }
            line = reader.readLine()
        }

        return content
    }


}
