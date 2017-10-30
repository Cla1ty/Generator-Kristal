package <%= appPackage %>.tool.recyclerview.adapter

/**
 * Created by Kristal on 6/14/2017.
 */

abstract class BaseItemLayout<DATA : RecyclerViewData>(
        clazz: Class<DATA>,
        internal val layoutId: Int) {
    internal val id: String = clazz.name
    internal var bind: ((holder: RecyclerViewHolder, data: RecyclerViewData) -> Unit)? = null

    var onClick: ((RecyclerViewHolder, DATA) -> Unit)? = null

    init {
        bind = { holder, data ->
            onBind(holder, data as DATA)
            holder.itemView.setOnClickListener {
                onClick?.invoke(holder, data)
            }
        }
    }

    abstract fun onCreate(holder: RecyclerViewHolder)
    abstract fun onBind(holder: RecyclerViewHolder, data: DATA)
}