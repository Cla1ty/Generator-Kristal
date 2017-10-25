package <%= appPackage %>.presentation.view.common

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.GridLayout


/**
 * Created by Dwi_Ari on 10/16/17.
 */

class GridMenu : GridLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onViewAdded(child: View?) {
        super.onViewAdded(child)

        resize(child!!)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        for (i in 0 until childCount) {
            resize(getChildAt(i))
        }

        postDelayed({ requestLayout() }, 1)
    }

    private fun resize(child: View) {
        val w = (width - paddingStart - paddingEnd) / columnCount
        val h = (height - paddingTop - paddingBottom) / rowCount

        child.layoutParams
                .apply {
                    width = w
                    height = h
                }
    }
}
