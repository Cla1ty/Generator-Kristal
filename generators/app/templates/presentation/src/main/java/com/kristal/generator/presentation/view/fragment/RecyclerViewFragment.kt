package <%= appPackage %>.presentation.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import <%= appPackage %>.R
import <%= appPackage %>.presentation.adapter.ExampleAdapter
import <%= appPackage %>.presentation.view.fragment.base.BaseFragment
import <%= appPackage %>.tool.recyclerview.adapter.data.IntData
import <%= appPackage %>.tool.recyclerview.adapter.data.StringData
import kotlinx.android.synthetic.main.fragment_recycler_view.*


/**
 * A simple [Fragment] subclass.
 */
class RecyclerViewFragment : BaseFragment() {

    override fun tag(): String = TAG

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                     savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_recycler_view, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf(
                StringData("A"),
                StringData("B"),
                StringData("C"),
                IntData(1),
                IntData(1),
                IntData(1),
                StringData("A"),
                StringData("B"),
                StringData("C"),
                IntData(1),
                IntData(1),
                IntData(1)
        )

        ExampleAdapter(recyclerView).apply {
            this.data = data
        }
    }

    companion object {
        val TAG = RecyclerViewFragment::class.java.simpleName
    }
}
