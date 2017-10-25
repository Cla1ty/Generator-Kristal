package <%= appPackage %>.domain.executor

import io.reactivex.Scheduler

/**
 * Created by Dwi_Ari on 10/13/17.
 */

interface PostExecutorThread {
    fun getScheduler(): Scheduler
}
