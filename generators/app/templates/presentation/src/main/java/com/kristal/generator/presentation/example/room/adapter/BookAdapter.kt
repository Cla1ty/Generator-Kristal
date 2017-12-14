package <%= appPackage %>.presentation.example.room.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import <%= appPackage %>.presentation.example.room.adapter.item.BookItem
import <%= appPackage %>.presentation.example.room.adapter.item.StringItem
import <%= appPackage %>.tool.extensions.dp
import <%= appPackage %>.tool.recyclerview.adapter.BaseRecyclerViewAdapter
import <%= appPackage %>.tool.recyclerview.decoration.LinearSpanContentDecoration
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class BookAdapter
@Inject constructor(
        val bookItem: BookItem,
        val stringItem: StringItem
) : BaseRecyclerViewAdapter(
        bookItem,
        stringItem
) {
    override fun build(recyclerView: RecyclerView) {
        recyclerView.apply {
            addItemDecoration(LinearSpanContentDecoration(8f.dp, true))
            layoutManager = LinearLayoutManager(recyclerView.context)
            adapter = this@BookAdapter
        }
    }
}

