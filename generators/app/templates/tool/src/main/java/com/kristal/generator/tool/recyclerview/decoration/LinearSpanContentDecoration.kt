package <%= appPackage %>.tool.recyclerview.decoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Kristal on 6/14/2017.
 */

/**
 * ______________________
 * |______________________|
 *
 *
 * <span>
 * ______________________
 * |______________________|
 * </span>
 */

class LinearSpanContentDecoration(protected var spanSize: Float, private val edge: Boolean) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val lIndex = parent.getChildLayoutPosition(view)

        outRect.left = when {
            edge -> spanSize.toInt()
            else -> 0
        }
        outRect.right = when {
            edge -> spanSize.toInt()
            else -> 0
        }

        outRect.top = when {
            edge && lIndex == 0 -> spanSize.toInt()
            !edge && lIndex >= 1 -> spanSize.toInt()
            else -> 0
        }
        outRect.bottom = when {
            edge -> spanSize.toInt()
            else -> 0
        }
    }
}