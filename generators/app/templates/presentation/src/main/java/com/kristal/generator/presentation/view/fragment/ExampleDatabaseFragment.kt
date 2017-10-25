package <%= appPackage %>.presentation.view.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import <%= appPackage %>.R
import <%= appPackage %>.presentation.model.ExampleModel
import <%= appPackage %>.presentation.presenter.ExampleDatabasePresenter
import <%= appPackage %>.presentation.view.ExampleView
import <%= appPackage %>.presentation.view.common.ColorText
import <%= appPackage %>.presentation.view.fragment.base.BaseFragmentMvp
import <%= appPackage %>.tool.log.Logger
import kotlinx.android.synthetic.main.fragment_learning.*


/**
 * A simple [Fragment] subclass.
 */
class ExampleDatabaseFragment : BaseFragmentMvp<ExampleDatabasePresenter>(), ExampleView {

    override fun tag(): String = TAG

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_example_database, container, false)

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
        Logger.i("RENDER")
        datas
                .map {
                    val data = it
                    ColorText(context, it)
                }.forEach {
            Logger.i("Grid $gridLayout")
            Logger.i("It $it")
            gridLayout.addView(it)
        }
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun context(): Context = context

    companion object {
        val TAG = ExampleDatabaseFragment::class.java.simpleName!!
    }
}
