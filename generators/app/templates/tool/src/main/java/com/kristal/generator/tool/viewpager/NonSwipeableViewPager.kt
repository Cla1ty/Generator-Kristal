package <%= appPackage %>.tool.viewpager

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by Dwi on 8/7/2017.
 */

class NonSwipeableViewPager : ViewPager {
    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    var isPagingEnabled = false

    override fun onTouchEvent(event: MotionEvent): Boolean =
            this.isPagingEnabled && super.onTouchEvent(event)

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean =
            this.isPagingEnabled && super.onInterceptTouchEvent(event)
}