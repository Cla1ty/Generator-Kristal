package <%= appPackage %>.tool.info

import android.content.Context
import android.content.pm.PackageManager
import <%= appPackage %>.tool.log.Logger


object AppInfo {
    var versionCode = -1
        private set
    var appName = "unknown"
        private set
    var versionName = "unknown"
        private set
    var label = "unknown"
        private set
    var packageName = "unknown"
        private set

    fun init(pContext: Context) {
        try {
            val lPackageInfo = pContext.packageManager.getPackageInfo(pContext.packageName, 0)
            val lInfo = pContext.applicationInfo
            val stringId = lInfo.labelRes

            appName = if (stringId == 0)
                lInfo.nonLocalizedLabel.toString()
            else
                pContext.getString(stringId)
            label = pContext.packageManager.getApplicationLabel(lInfo) as String
            versionCode = lPackageInfo.versionCode
            versionName = lPackageInfo.versionName
            packageName = pContext.packageName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        Logger.i(AppInfo::class.java)
    }
}
