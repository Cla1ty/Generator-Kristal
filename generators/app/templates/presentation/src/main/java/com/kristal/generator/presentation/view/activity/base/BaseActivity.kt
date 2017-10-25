package <%= appPackage %>.presentation.view.activity.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import <%= appPackage %>.presentation.navigation.Navigator
import <%= appPackage %>.presentation.view.fragment.base.BaseFragment
import <%= appPackage %>.tool.log.Logger
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/14/17.
 */

abstract class BaseActivity
    : AppCompatActivity() {
    @Inject
    lateinit var navigator: Navigator
    lateinit var setup: Setup

    val currentFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(setup.containerId)

    abstract fun setup(): Setup

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        setup = setup()
        Logger.lifecycle(setup.tag)
        super.onCreate(savedInstanceState)

        supportFragmentManager.addOnBackStackChangedListener {
            for (i in 0 until supportFragmentManager.backStackEntryCount) {
                Logger.i("Name: ${supportFragmentManager.getBackStackEntryAt(i).name}")
            }
        }
    }

    override fun onStart() {
        Logger.lifecycle(setup.tag)
        super.onStart()
    }

    override fun onResume() {
        Logger.lifecycle(setup.tag)
        super.onResume()
    }

    override fun onPause() {
        Logger.lifecycle(setup.tag)
        super.onPause()
    }

    override fun onStop() {
        Logger.lifecycle(setup.tag)
        super.onStop()
    }

    override fun onDestroy() {
        Logger.lifecycle(setup.tag)
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (currentFragment != null && (currentFragment as BaseFragment).onBackPressed()) return
        super.onBackPressed()
    }

    fun replaceFragment(fragment: BaseFragment, layoutId: Int = setup.containerId) {
        supportFragmentManager.beginTransaction()
                .replace(layoutId, fragment)
                .addToBackStack(fragment.tag())
                .commit()
    }

    fun addFragment(fragment: BaseFragment, layoutId: Int = setup.containerId) {
        supportFragmentManager.beginTransaction()
                .add(layoutId, fragment, fragment.tag())
                .addToBackStack(fragment.tag())
                .commit()
    }

    protected fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    class Setup(val tag: String, val containerId: Int = DEFAULT_CONTAINER_ID)

    companion object {
        protected val DEFAULT_CONTAINER_ID = android.R.id.content
    }
}
