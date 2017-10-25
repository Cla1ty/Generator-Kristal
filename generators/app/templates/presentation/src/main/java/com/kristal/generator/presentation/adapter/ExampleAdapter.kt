package <%= appPackage %>.presentation.adapter

import android.support.v7.widget.RecyclerView
import <%= appPackage %>.presentation.adapter.item.IntegerItem
import <%= appPackage %>.presentation.adapter.item.StringItem
import <%= appPackage %>.tool.recyclerview.adapter.BaseRecyclerViewAdapter

/**
 * Created by Dwi_Ari on 10/24/17.
 */

class ExampleAdapter(
        recyclerView: RecyclerView
) : BaseRecyclerViewAdapter(recyclerView) {
    init {
        register(StringItem())
        register(IntegerItem())
        verticalGridLayoutManager(2)
        apply()
    }
}
