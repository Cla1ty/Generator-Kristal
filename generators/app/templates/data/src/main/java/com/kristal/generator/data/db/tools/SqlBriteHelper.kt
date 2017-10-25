package <%= appPackage %>.data.db.tools

import android.database.sqlite.SQLiteOpenHelper
import <%= appPackage %>.domain.executor.ThreadExecutor
import com.squareup.sqlbrite2.BriteDatabase
import com.squareup.sqlbrite2.SqlBrite
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/23/17.
 */

internal class SqlBriteHelper
@Inject internal constructor(
        private val executor: ThreadExecutor
) {
    @Singleton
    fun getSqlBrite() = SqlBrite.Builder().build()

    fun getDatabase(helper: SQLiteOpenHelper): BriteDatabase =
            getSqlBrite().wrapDatabaseHelper(helper, Schedulers.from(executor))
                    .apply {
                        setLoggingEnabled(true)
                    }

}
