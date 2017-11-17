package <%= appPackage %>.domain.interactor.base

import <%= appPackage %>.domain.executor.PostExecutorThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import org.jetbrains.annotations.TestOnly

/**
 * Created by Dwi_Ari on 10/13/17.
 */

abstract class UseCaseSqlBrite<T, in PARAMS>
internal constructor(
        private val postExecutorThread: PostExecutorThread
) {
    private var disposable: Disposable? = null
    private val compositeDisposable = CompositeDisposable()

    abstract fun build(params: PARAMS?): Observable<T>

    fun execute(next: (T) -> Unit, error: (Throwable) -> Unit, params: PARAMS? = null) {
        val observable: Observable<T> =
                build(params).observeOn(postExecutorThread.getScheduler())

        disposable = observable.subscribe(
                {
                    next.invoke(it)
                },
                {
                    error.invoke(it)
                }
        ).addTo(compositeDisposable)
    }

    fun dispose() {
        compositeDisposable.dispose()
    }

    fun stop() {
        disposable?.dispose()
    }

    @TestOnly
    fun isCompositeDispose() = compositeDisposable.isDisposed

    @TestOnly
    fun isDispose() = disposable?.isDisposed ?: false
}