package <%= appPackage %>.presentation.example.room.view.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import <%= appPackage %>.R
import <%= appPackage %>.presentation.example.room.adapter.BookAdapter
import <%= appPackage %>.presentation.example.room.presenter.RoomPresenter
import <%= appPackage %>.presentation.example.room.view.RoomView
import <%= appPackage %>.presentation.view.fragment.base.BaseFragmentMvp
import <%= appPackage %>.tool.recyclerview.adapter.data.StringData
import <%= appPackage %>.tool.text.gone
import <%= appPackage %>.tool.text.invisible
import <%= appPackage %>.tool.text.visible
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class RoomFragment : BaseFragmentMvp<RoomPresenter>(), RoomView {
    @Inject
    lateinit var adapter: BookAdapter

    override fun tag(): String = TAG

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater!!.inflate(R.layout.fragment_recycler_view, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.recyclerView = recyclerView
    }

    override fun showLoading() {
        btnRetry.gone()
        progressBar.visible()
        recyclerView.invisible()
    }

    override fun hideLoading() {
        progressBar.gone()
        recyclerView.visible()
    }

    override fun showRetry() {
        btnRetry.visible()
        progressBar.gone()
        recyclerView.invisible()
    }

    override fun hideRetry() {
        btnRetry.invisible()
        recyclerView.visible()
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun context(): Context = context

    override fun renderView(datas: List<StringData>) {
        adapter.data = datas
    }

    companion object {
        val TAG = RoomFragment::class.java.simpleName!!
    }
}
