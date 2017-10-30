package <%= appPackage %>.domain.interactor.base

import io.reactivex.observers.DisposableObserver

/**
 * Created by Dwi_Ari on 10/15/17.
 */

class DefaultDisposableObserver<T>(
        private val next: ((T) -> Unit)? = null,
        private val error: ((Throwable) -> Unit)? = null,
        private val complete: (() -> Unit)? = null
) : DisposableObserver<T>() {
    override fun onNext(t: T) {
        next?.invoke(t)
    }

    override fun onError(e: Throwable) {
        error?.invoke(e)
    }

    override fun onComplete() {
        complete?.invoke()
    }
}
