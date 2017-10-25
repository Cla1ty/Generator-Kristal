package <%= appPackage %>.presentation.presenter.base

/**
 * Created by Dwi_Ari on 10/14/17.
 */

abstract class BasePresenter<out VIEW>(
        protected val view: VIEW
) {
    open fun start() {}
    open fun resume() {}
    open fun pause() {}
    open fun stop() {}
    open fun destroy() {}
}
