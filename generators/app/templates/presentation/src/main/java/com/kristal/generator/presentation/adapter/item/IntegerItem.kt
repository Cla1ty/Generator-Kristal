package <%= appPackage %>.presentation.adapter.item

import <%= appPackage %>.R
import <%= appPackage %>.tool.recyclerview.adapter.BaseItemLayout
import <%= appPackage %>.tool.recyclerview.adapter.RecyclerViewHolder
import <%= appPackage %>.tool.recyclerview.adapter.data.IntData
import kotlinx.android.synthetic.main.item_int.view.*

/**
 * Created by Dwi_Ari on 10/24/17.
 */

class IntegerItem : BaseItemLayout<IntData>(
        IntData::class.java,
        R.layout.item_int) {
    override fun onCreate(holder: RecyclerViewHolder) {

    }

    override fun onBind(holder: RecyclerViewHolder, data: IntData) {
        holder.itemView.txt_int.text = data.value.toString()
    }
}
