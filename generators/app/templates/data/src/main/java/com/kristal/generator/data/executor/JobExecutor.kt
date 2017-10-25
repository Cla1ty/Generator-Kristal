package <%= appPackage %>.data.executor

import <%= appPackage %>.domain.executor.ThreadExecutor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/14/17.
 */

@Singleton
class JobExecutor
@Inject internal constructor()
    : ThreadExecutor {

    private val executor = ThreadPoolExecutor(
            3, 5,
            10, TimeUnit.SECONDS,
            LinkedBlockingQueue(),
            JobThreadFactory())

    override fun execute(command: Runnable?) {
        executor.execute(command)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(r: Runnable?): Thread = Thread(r, "android_" + counter++)
    }
}
