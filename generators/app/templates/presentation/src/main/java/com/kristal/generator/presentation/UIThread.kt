package <%= appPackage %>.presentation

import <%= appPackage %>.domain.executor.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/14/17.
 */

@Singleton
class UIThread
@Inject internal constructor()
    : PostExecutorThread {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}
