package <%= appPackage %>.presentation.example_room.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import <%= appPackage %>.presentation.example_room.adapter.item.BookItem
import <%= appPackage %>.presentation.example_room.adapter.item.StringItem
import <%= appPackage %>.tool.extensions.dp
import <%= appPackage %>.tool.recyclerview.adapter.BaseRecyclerViewAdapter
import <%= appPackage %>.tool.recyclerview.decoration.LinearSpanContentDecoration

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class BookAdapter(
        recyclerView: RecyclerView
) : BaseRecyclerViewAdapter() {
    val bookItem = BookItem()

    init {
        register(bookItem)
        register(StringItem())

        recyclerView.addItemDecoration(LinearSpanContentDecoration(8f.dp, true))
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = this
    }
}

