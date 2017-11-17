package <%= appPackage %>.presentation.example_room.adapter.item

import <%= appPackage %>.R
import <%= appPackage %>.presentation.example_room.model.BookModel
import <%= appPackage %>.tool.recyclerview.adapter.BaseItemLayout
import <%= appPackage %>.tool.recyclerview.adapter.RecyclerViewHolder
import kotlinx.android.synthetic.main.item_string.view.*

/**
 * Created by Dwi_Ari on 10/24/17.
 */

class BookItem : BaseItemLayout<BookModel>(
        BookModel::class.java,
        R.layout.item_string
) {
    override fun onCreate(holder: RecyclerViewHolder) {

    }

    override fun onBind(holder: RecyclerViewHolder, data: BookModel) {
        holder.itemView.txt_string.text = data.title
    }
}