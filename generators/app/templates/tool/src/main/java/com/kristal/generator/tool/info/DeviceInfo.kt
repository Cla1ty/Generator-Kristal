package <%= appPackage %>.tool.info

import android.content.Context
import android.provider.Settings
import android.telephony.TelephonyManager
import <%= appPackage %>.tool.log.Logger

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
    var deviceId = ""
        private set

    fun init(pContext: Context) {
        val lDisplayMetrics = pContext.resources.displayMetrics
        screenWidth = lDisplayMetrics.widthPixels
        screenHeight = lDisplayMetrics.heightPixels
        density = lDisplayMetrics.density
        scaledDensity = lDisplayMetrics.scaledDensity
        deviceId = Settings.Secure.getString(pContext.contentResolver, Settings.Secure.ANDROID_ID)
        Logger.i(DeviceInfo::class.java)
    }

    fun initPermission(context: Context) {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        deviceId = telephonyManager.deviceId
        Logger.i(DeviceInfo::class.java)
    }
}
