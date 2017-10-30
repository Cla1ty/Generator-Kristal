package <%= appPackage %>.presentation.utils

import android.support.v4.app.FragmentManager
import <%= appPackage %>.presentation.view.fragment.base.BaseFragment

/**
 * Created by Dwi_Ari on 10/28/17.
 */

object FragmentHelper{
    fun <FRAGMENT : BaseFragment> getFragment(fragmentManager: FragmentManager, clazz: Class<FRAGMENT>): FRAGMENT? {
        val fragment = fragmentManager.fragments.firstOrNull {
            it::class.java.name == clazz.name
        } ?: return null
        return fragment as FRAGMENT
    }
}