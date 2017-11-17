package <%= appPackage %>.domain.interactor.base

import <%= appPackage %>.domain.executor.PostExecutorThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dwi_Ari on 10/13/17.
 */

abstract class UseCaseFlowable<T, PARAMS>
internal constructor(
        private val threadExecutor: ThreadExecutor,
        private val postExecutorThread: PostExecutorThread
) {
    private val compositeDisposable = CompositeDisposable()
    private var disposable: Disposable? = null

    abstract fun build(params: PARAMS? = null): Flowable<T>

    fun execute(next: (T) -> Unit, error: (Throwable) -> Unit, params: PARAMS? = null) {
        val observable: Flowable<T> =
                build(params)
                        .subscribeOn(Schedulers.from(threadExecutor))
                        .observeOn(postExecutorThread.getScheduler())

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
}
