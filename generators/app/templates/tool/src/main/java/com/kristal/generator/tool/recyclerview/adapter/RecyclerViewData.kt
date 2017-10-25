package <%= appPackage %>.tool.recyclerview.adapter

/**
 * Created by Kristal on 6/14/2017.
 */

interface RecyclerViewData {
    fun isSameId(otherData: RecyclerViewData): Boolean
    fun isSameData(otherData: RecyclerViewData): Boolean
}
