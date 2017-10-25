package <%= appPackage %>.tool.recyclerview.adapter

/**
 * Created by Kristal on 6/14/2017.
 */

abstract class BaseItemLayout<in DATA : RecyclerViewData>(
        clazz: Class<DATA>,
        internal val layoutId: Int) {
    internal val id: String = clazz.name
    internal var bind: ((holder: RecyclerViewHolder, data: RecyclerViewData) -> Unit)? = null

    init {
        bind = { holder, data ->
            onBind(holder, data as DATA)
            holder.itemView.setOnClickListener {
                onClick(holder, data as DATA)
            }
        }
    }

    abstract fun onCreate(holder: RecyclerViewHolder)
    abstract fun onBind(holder: RecyclerViewHolder, data: DATA)
    abstract fun onClick(holder: RecyclerViewHolder, data: DATA)
}