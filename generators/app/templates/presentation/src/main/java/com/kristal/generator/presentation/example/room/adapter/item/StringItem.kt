package <%= appPackage %>.presentation.example.room.adapter.item

import <%= appPackage %>.R
import <%= appPackage %>.tool.recyclerview.adapter.BaseItemLayout
import <%= appPackage %>.tool.recyclerview.adapter.RecyclerViewHolder
import <%= appPackage %>.tool.recyclerview.adapter.data.StringData
import kotlinx.android.synthetic.main.item_string.view.*
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/24/17.
 */

class StringItem
@Inject constructor() : BaseItemLayout<StringData>(
        StringData::class.java,
        R.layout.item_string
) {
    override fun onCreate(holder: RecyclerViewHolder) {

    }

    override fun onBind(holder: RecyclerViewHolder, data: StringData) {
        holder.itemView.txt_string.text = data.string
    }
}