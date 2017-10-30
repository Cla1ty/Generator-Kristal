package <%= appPackage %>.presentation.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import <%= appPackage %>.presentation.adapter.item.IntegerItem
import <%= appPackage %>.presentation.adapter.item.StringItem
import <%= appPackage %>.tool.extensions.dp
import <%= appPackage %>.tool.recyclerview.adapter.BaseRecyclerViewAdapter
import <%= appPackage %>.tool.recyclerview.decoration.LinearSpanContentDecoration

/**
 * Created by Dwi_Ari on 10/24/17.
 */

class ExampleAdapter(
        private val recyclerView: RecyclerView
) : BaseRecyclerViewAdapter() {
    val stringItem = StringItem()

    init {
        register(StringItem())
        register(IntegerItem())

        recyclerView.addItemDecoration(LinearSpanContentDecoration(8f.dp, true))
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = this
    }
}
