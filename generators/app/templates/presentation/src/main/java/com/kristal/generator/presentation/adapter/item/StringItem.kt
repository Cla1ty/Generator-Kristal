package <%= appPackage %>.presentation.adapter.item

import <%= appPackage %>.R
import <%= appPackage %>.tool.recyclerview.adapter.BaseItemLayout
import <%= appPackage %>.tool.recyclerview.adapter.RecyclerViewHolder
import <%= appPackage %>.tool.recyclerview.adapter.data.StringData
import kotlinx.android.synthetic.main.item_string.view.*

/**
 * Created by Dwi_Ari on 10/24/17.
 */

class StringItem : BaseItemLayout<StringData>(
        StringData::class.java,
        R.layout.item_string
) {
    override fun onCreate(holder: RecyclerViewHolder) {

    }

    override fun onBind(holder: RecyclerViewHolder, data: StringData) {
        holder.itemView.txt_string.text = data.string
    }
}