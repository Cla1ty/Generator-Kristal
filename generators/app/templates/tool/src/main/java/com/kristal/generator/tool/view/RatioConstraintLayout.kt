package <%= appPackage %>.tool.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import <%= appPackage %>.tool.R


/**
 * Created by Kristal on 6/15/2017.
 */

class RatioConstraintLayout : ConstraintLayout {
    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    private var scale = -1

    private fun init(attrs: AttributeSet) {
        val styleAttr = context.obtainStyledAttributes(attrs, R.styleable.RatioConstraintLayout)
        scale = styleAttr.getInt(R.styleable.RatioConstraintLayout_scale, -1)
        styleAttr.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        when (scale) {
            0 -> super.onMeasure(heightMeasureSpec, heightMeasureSpec)
            1 -> super.onMeasure(widthMeasureSpec, widthMeasureSpec)
            else -> super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}
