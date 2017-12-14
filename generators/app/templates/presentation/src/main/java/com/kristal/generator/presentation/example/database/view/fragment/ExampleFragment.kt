package <%= appPackage %>.presentation.example.database.view.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import <%= appPackage %>.R
import <%= appPackage %>.presentation.example.database.model.ExampleModel
import <%= appPackage %>.presentation.example.database.presenter.ExamplePresenter
import <%= appPackage %>.presentation.example.database.view.ExampleView
import <%= appPackage %>.presentation.view.common.ColorText
import <%= appPackage %>.presentation.view.fragment.base.BaseFragmentMvp
import <%= appPackage %>.tool.log.info
import kotlinx.android.synthetic.main.fragment_learning.*


/**
 * A simple [Fragment] subclass.
 */
class ExampleFragment : BaseFragmentMvp<ExamplePresenter>(), ExampleView {
    override fun tag(): String = TAG

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_learning, container, false)

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
        gridLayout.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
        gridLayout.visibility = View.VISIBLE
    }

    override fun showRetry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideRetry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderView(datas: List<ExampleModel>) {
        info("RENDER")
        datas
                .map {
                    val data = it
                    ColorText(context, it)
                }.forEach {
            gridLayout.addView(it)
        }
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun context(): Context = context

    companion object {
        val TAG = ExampleFragment::class.java.simpleName!!
    }
}
