package <%= appPackage %>.presentation.view

import android.content.Context

/**
 * Created by Dwi_Ari on 10/14/17.
 */
interface LoadDataView {
    fun showLoading()
    fun hideLoading()
    fun showRetry()
    fun hideRetry()
    fun showError(message:String)
    fun context(): Context

}
