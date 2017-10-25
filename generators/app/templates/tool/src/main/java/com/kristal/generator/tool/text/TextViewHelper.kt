package <%= appPackage %>.tool.text

import android.graphics.Paint
import android.graphics.Rect
import android.view.ViewTreeObserver
import android.widget.TextView
import <%= appPackage %>.tool.MathHelper

/**
 * Created by Dwi on 8/4/2017.
 */

object TextViewHelper {
    fun setTextAutoResize(pView: TextView, pString: String) {
        pView.text = pString
        pView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                pView.viewTreeObserver.removeOnPreDrawListener(this)

                val bounds = Rect()
                val textPaint = Paint(pView.paint)
                var lTextSize = pView.paint.textSize

//                Trace.debug("Default Text Size: " + lTextSize)

                var width = 0
                var isFirst = true
                do {
                    if (isFirst)
                        isFirst = false
                    else
                        lTextSize--

                    textPaint.textSize = lTextSize
                    textPaint.getTextBounds(pString, 0, pString.length, bounds)

                    width = bounds.width()
//                    Trace.debug("Default Width: " + pView.width + ", New Width: " + width)
                } while (pView.width < width)

//                Trace.debug("New Text Size: " + lTextSize)
                val lNewTextSize = MathHelper.px2Sp(lTextSize) - 2
                pView.textSize = lNewTextSize
//                Trace.debug("New Text Size: " + pView.textSize)
                return true
            }
        })
    }

    fun setTextAutoResizeVertical(pView: TextView, pString: String) {
        pView.text = pString
//        Trace.debug("Default Text Size: " + 1)
        pView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                pView.viewTreeObserver.removeOnPreDrawListener(this)

                val bounds = Rect()
                val textPaint = Paint(pView.paint)
                var lTextSize = pView.paint.textSize
                val lineCount = pView.lineCount

//                Trace.debug("Default Text Size: " + lTextSize)

                var height = 0f
                var isFirst = true
                do {
                    if (isFirst)
                        isFirst = false
                    else
                        lTextSize--

//                    Trace.debug("New Text Size: " + lTextSize)
                    val lNewTextSize = MathHelper.px2Sp(lTextSize)
                    pView.textSize = lNewTextSize

                    height = (pView.lineHeight * lineCount).toFloat()
//                    Trace.debug("Default Height: " + pView.height + ", New Height: " + height + ", New Height: " + pView.lineHeight)
                } while (pView.height < height)

                //				Trace.debug("New Text Size: " + lTextSize);
                //				float lNewTextSize = MathTools.px2Sp(lTextSize);
                //				pView.setTextSize(lNewTextSize);
                //				Trace.debug("New Text Size: " + pView.getTextSize());
                return true
            }
        })
    }
}
