package <%= appPackage %>.tool.recyclerview.scrollListener

import android.support.v7.widget.RecyclerView

/**
 * Created by Dwi on 7/5/2017.
 */

class SimpleLoadMore(private val loadMore: () -> Unit) : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        if (dy > 0 && !recyclerView!!.canScrollVertically(1)) {
            loadMore.invoke()
        }
    }
}
