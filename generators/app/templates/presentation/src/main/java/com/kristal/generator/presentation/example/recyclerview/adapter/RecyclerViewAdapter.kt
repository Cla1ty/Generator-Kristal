package <%= appPackage %>.presentation.example.recyclerview.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import <%= appPackage %>.presentation.example.recyclerview.adapter.item.IntegerItem
import <%= appPackage %>.presentation.example.recyclerview.adapter.item.StringItem
import <%= appPackage %>.tool.extensions.dp
import <%= appPackage %>.tool.recyclerview.adapter.BaseRecyclerViewAdapter
import <%= appPackage %>.tool.recyclerview.decoration.LinearSpanContentDecoration
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/24/17.
 */

class RecyclerViewAdapter
@Inject constructor(
        val stringItem: StringItem,
        val integerItem: IntegerItem
) : BaseRecyclerViewAdapter(
        stringItem,
        integerItem
) {
    override fun build(recyclerView: RecyclerView) {
        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(LinearSpanContentDecoration(8f.dp, true))
            layoutManager = LinearLayoutManager(context)
            adapter = this@RecyclerViewAdapter
        }
    }
}
