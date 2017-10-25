package <%= appPackage %>.domain.interactor

import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dwi_Ari on 10/13/17.
 */

abstract class UseCase<T, PARAMS>
internal constructor(
        private val threadExecutor: ThreadExecutor,
        private val postExecutorThread: PostExecutorThread
) {
    private val disposable = CompositeDisposable()

    abstract fun build(params: PARAMS?): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: PARAMS?) {
        val observable: Observable<T> =
                build(params).subscribeOn(Schedulers.from(threadExecutor))
                        .observeOn(postExecutorThread.getScheduler())

        disposable.add(observable.subscribeWith(observer))
    }

    fun dispose() {
        disposable.dispose()
    }
}
