package <%= appPackage %>.presentation.view.activity

import android.os.Bundle
import android.os.Handler
import <%= appPackage %>.R
import <%= appPackage %>.domain.repository.ApplicationRepository
import <%= appPackage %>.presentation.view.activity.base.BaseActivity
import java.util.*
import javax.inject.Inject



class SplashActivity : BaseActivity() {
    override fun setup(): Setup = Setup(TAG)

    @Inject
    lateinit var app: ApplicationRepository

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (app.lang == ApplicationRepository.NONE) {
            app.lang = ApplicationRepository.UK
            app.lang = when (Locale.getDefault().language) {
                "in" -> ApplicationRepository.INDO
                else -> ApplicationRepository.UK
            }
        }

        handler.postDelayed({
            navigator.navigationToHome(this)
            finish()
        }, 2000)
    }

    companion object {
        val TAG = SplashActivity::class.java.simpleName!!
    }
}
