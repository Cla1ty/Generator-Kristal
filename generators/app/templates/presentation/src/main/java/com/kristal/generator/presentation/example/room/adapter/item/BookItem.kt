package <%= appPackage %>.presentation.example.room.adapter.item

import <%= appPackage %>.R
import <%= appPackage %>.presentation.example.room.model.BookModel
import <%= appPackage %>.tool.recyclerview.adapter.BaseItemLayout
import <%= appPackage %>.tool.recyclerview.adapter.RecyclerViewHolder
import kotlinx.android.synthetic.main.item_string.view.*
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/24/17.
 */

class BookItem
@Inject constructor() : BaseItemLayout<BookModel>(
        BookModel::class.java,
        R.layout.item_string
) {
    override fun onCreate(holder: RecyclerViewHolder) {

    }

    override fun onBind(holder: RecyclerViewHolder, data: BookModel) {
        holder.itemView.txt_string.text = data.title
    }
}