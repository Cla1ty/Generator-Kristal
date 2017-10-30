package <%= appPackage %>.domain.interactor.base

import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dwi_Ari on 10/13/17.
 */

abstract class UseCase<T, PARAMS>
internal constructor(
        private val threadExecutor: ThreadExecutor,
        private val postExecutorThread: PostExecutorThread
) {
    private val compositeDisposable = CompositeDisposable()
    private var disposable: Disposable? = null

    abstract fun build(params: PARAMS?): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: PARAMS?) {
        val observable: Observable<T> =
                build(params).subscribeOn(Schedulers.from(threadExecutor))
                        .observeOn(postExecutorThread.getScheduler())

        disposable = observable.subscribeWith(observer)
                .addTo(compositeDisposable)
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
