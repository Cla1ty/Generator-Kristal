package <%= appPackage %>.presentation.view.fragment.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import <%= appPackage %>.presentation.navigation.Navigator
import <%= appPackage %>.presentation.utils.FragmentHelper
import <%= appPackage %>.presentation.view.activity.base.BaseActivity
import <%= appPackage %>.tool.log.debug
import <%= appPackage %>.tool.log.printMethod
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/14/17.
 */

abstract class BaseFragment : Fragment() {
    @Inject
    lateinit var navigator: Navigator
    var baseActivity: BaseActivity? = null

    abstract fun tag(): String

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        printMethod(tag())
        baseActivity = when (activity is BaseActivity) {
            true -> activity as BaseActivity
            else -> null
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        printMethod(tag())
        super.onStart()
    }

    override fun onResume() {
        printMethod(tag())
        super.onResume()
    }

    override fun onPause() {
        printMethod(tag())
        super.onPause()
    }

    override fun onStop() {
        printMethod(tag())
        super.onStop()
    }

    override fun onDestroy() {
        printMethod(tag())
        super.onDestroy()
    }

    open fun onBackPressed(): Boolean = false

    protected fun <FRAGMENT : BaseFragment> getFragment(clazz: Class<FRAGMENT>): FRAGMENT? =
            FragmentHelper.getFragment(childFragmentManager, clazz)

    protected fun toast(message: String) {
        debug(message)
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}