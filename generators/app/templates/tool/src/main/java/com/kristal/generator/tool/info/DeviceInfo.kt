package <%= appPackage %>.tool.info

import android.content.Context
import <%= appPackage %>.tool.log.info

/**
 * Created by Kristal on 2/7/2017.
 */

object DeviceInfo {
    var screenWidth: Int = 0
        private set
    var screenHeight: Int = 0
        private set
    var scaledDensity: Float = 0.toFloat()
        private set
    var density: Float = 0.toFloat()
        private set

    fun init(pContext: Context) {
        val lDisplayMetrics = pContext.resources.displayMetrics
        screenWidth = lDisplayMetrics.widthPixels
        screenHeight = lDisplayMetrics.heightPixels
        density = lDisplayMetrics.density
        scaledDensity = lDisplayMetrics.scaledDensity
        info(DeviceInfo::class.java)
    }
}
