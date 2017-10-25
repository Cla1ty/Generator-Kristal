package <%= appPackage %>.presentation.view.fragment.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import <%= appPackage %>.presentation.navigation.Navigator
import <%= appPackage %>.presentation.view.activity.base.BaseActivity
import <%= appPackage %>.tool.log.Logger
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/14/17.
 */

abstract class BaseFragment : Fragment() {
    @Inject
    lateinit var navigator: Navigator
    var baseActivity: BaseActivity? = null

    private val clickList = ArrayList<ClickData>()

    abstract fun tag(): String

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        Logger.lifecycle(tag())
        baseActivity = when (activity is BaseActivity) {
            true -> activity as BaseActivity
            else -> null
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Logger.lifecycle(tag())
        super.onStart()
    }

    override fun onResume() {
        Logger.lifecycle(tag())
        super.onResume()

        for (clickData in clickList) {
            clickData.view.setOnClickListener(clickData.click)
        }
    }

    override fun onPause() {
        Logger.lifecycle(tag())
        super.onPause()

        for (clickData in clickList) {
            clickData.view.setOnClickListener(null)
        }
    }

    override fun onStop() {
        Logger.lifecycle(tag())
        super.onStop()
    }

    override fun onDestroy() {
        Logger.lifecycle(tag())
        super.onDestroy()
    }

    open fun onBackPressed(): Boolean = false

    protected fun registerClick(view: View, click: View.OnClickListener) {
        clickList.add(ClickData(view, click))
    }

    protected fun toast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private class ClickData(val view: View, val click: View.OnClickListener)
}
