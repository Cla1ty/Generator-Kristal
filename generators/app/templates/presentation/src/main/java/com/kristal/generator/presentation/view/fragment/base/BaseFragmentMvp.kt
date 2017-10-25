package <%= appPackage %>.presentation.view.fragment.base

import <%= appPackage %>.presentation.presenter.base.BasePresenter
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/14/17.
 */

abstract class BaseFragmentMvp<PRESENTER : BasePresenter<*>>
    : BaseFragment() {
    @Inject
    protected lateinit var presenter: PRESENTER

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
