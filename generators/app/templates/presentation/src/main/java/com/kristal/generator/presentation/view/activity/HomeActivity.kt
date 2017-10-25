package <%= appPackage %>.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import <%= appPackage %>.presentation.view.activity.base.BaseActivity
import <%= appPackage %>.presentation.view.fragment.ExampleDatabaseFragment
import <%= appPackage %>.presentation.view.fragment.RecyclerViewFragment


class HomeActivity : BaseActivity() {
    override fun setup(): Setup = Setup(TAG)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(RecyclerViewFragment())
    }

    companion object {
        val TAG = HomeActivity::class.java.simpleName!!
        fun getIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }
}
