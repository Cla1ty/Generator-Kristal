package <%= appPackage %>.presentation.example.room.view.activity

import android.os.Bundle
import <%= appPackage %>.presentation.example.room.view.fragment.RoomFragment
import <%= appPackage %>.presentation.view.activity.base.BaseActivity

class RoomActivity : BaseActivity() {
    override fun setup():
            Setup = Setup(TAG)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(RoomFragment())
    }

    companion object {
        val TAG = RoomActivity::class.java.simpleName
    }
}
