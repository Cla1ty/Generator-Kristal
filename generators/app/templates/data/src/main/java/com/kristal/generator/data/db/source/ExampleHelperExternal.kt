package <%= appPackage %>.data.db.source

import android.content.Context
import <%= appPackage %>.data.db.source.base.BaseHelperExternal
import <%= appPackage %>.data.db.tools.SqlBriteHelper
import com.squareup.sqlbrite2.BriteDatabase
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/23/17.
 */

@Singleton
internal class ExampleHelperExternal
@Inject constructor(
        context: Context,
        private val helper: SqlBriteHelper
) : BaseHelperExternal(context, "data.db") {
    fun getDatabase(): BriteDatabase = helper.getDatabase(this)
}