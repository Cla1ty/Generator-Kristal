package <%= appPackage %>.domain.interactor.base

import <%= appPackage %>.domain.executor.PostExecutorThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

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

    fun execute(observer: DefaultObservable<T>, params: PARAMS? = null) {
        val observable: Observable<T> =
                build(params).observeOn(postExecutorThread.getScheduler())

        disposable = observable.subscribe(
                {
                    observer.complete.invoke()
                    observer.next.invoke(it)
                },
                {
                    observer.error.invoke(it)
                }
        ).addTo(compositeDisposable)
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }

    fun stop() {
        if (disposable == null) return

        if (!disposable!!.isDisposed)
            disposable!!.dispose()
    }
}