package <%= appPackage %>.presentation.navigation

import android.content.Context
import <%= appPackage %>.presentation.view.activity.HomeActivity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/14/17.
 */

@Singleton
class Navigator
@Inject internal constructor() {

    fun navigationToHome(context: Context) {
        HomeActivity.getIntent(context)
                .also {
                    context.startActivity(it)
                }
    }
}
