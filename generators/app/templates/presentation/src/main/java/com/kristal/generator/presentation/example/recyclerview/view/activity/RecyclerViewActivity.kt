package <%= appPackage %>.presentation.example.recyclerview.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import <%= appPackage %>.presentation.example.recyclerview.view.fragment.RecyclerViewFragment
import <%= appPackage %>.presentation.view.activity.base.BaseActivity

class RecyclerViewActivity : BaseActivity() {
    override fun setup(): Setup = Setup(TAG)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(RecyclerViewFragment())
    }

    companion object {
        val TAG = RecyclerViewActivity::class.java.simpleName!!
        fun getIntent(context: Context): Intent = Intent(context, RecyclerViewActivity::class.java)
    }
}

