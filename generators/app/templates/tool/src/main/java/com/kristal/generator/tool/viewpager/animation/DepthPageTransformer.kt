package <%= appPackage %>.tool.viewpager.animation

import android.support.v4.view.ViewPager
import android.view.View

/**
 * Created by Kristal on 5/22/2017.
 */

class DepthPageTransformer(
        private val minScale: Float = DEFAULT_MIN_SCALE
) : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        val pageWidth = view.width

        if (position < -1 || position > 1) {
            view.alpha = 0f
        } else if (position <= 0) {
            view.alpha = 1f
            view.translationX = 0f
            view.scaleX = 1f
            view.scaleY = 1f

        } else if (position <= 1) {
            view.alpha = 1 - position
            view.translationX = pageWidth * -position

            val scaleFactor = minScale + (1 - minScale) * (1 - Math.abs(position))
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor

        }

    }

    companion object {
        val DEFAULT_MIN_SCALE = 0.75f
    }
}
