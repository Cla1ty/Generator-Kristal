package <%= appPackage %>.presentation.view.base

import android.content.Context

/**
 * Created by Dwi_Ari on 10/14/17.
 */

interface LoadDataView<in DATA> {
    fun renderView(data: DATA)
    fun showLoading()
    fun hideLoading()
    fun showRetry()
    fun hideRetry()
    fun showError(message: String)
    fun context(): Context

}