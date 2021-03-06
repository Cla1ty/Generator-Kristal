package <%= appPackage %>.tool.animation

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.graphics.Rect
import android.view.View
import android.view.animation.*
import <%= appPackage %>.tool.R


/**
 * Created by Kristal on 8/15/2017.
 */

// region Animation

fun View.fadeInAnimation() = inAnimation(R.anim.fade_in)

fun View.fadeOutAnimation() = outAnimation(R.anim.fade_out)
fun View.slideLeftInAnimation() = inAnimation(R.anim.slide_left_in)
fun View.slideLeftOutAnimation() = outAnimation(R.anim.slide_left_out)
fun View.slideTopInAnimation() = inAnimation(R.anim.slide_top_in)
fun View.slideTopOutAnimation() = outAnimation(R.anim.slide_top_out)
fun View.slideRightInAnimation() = inAnimation(R.anim.slide_right_in)
fun View.slideRightOutAnimation() = outAnimation(R.anim.slide_right_out)
fun View.slideBottomInAnimation() = inAnimation(R.anim.slide_bottom_in)
fun View.slideBottomOutAnimation() = outAnimation(R.anim.slide_bottom_out)

fun View.cancelAnimation() {
    animation ?: return
    animation.setAnimationListener(null)
    animation.cancel()
}

fun View.loadAnimation(resId: Int): Animation {
    cancelAnimation()
    return AnimationUtils.loadAnimation(context, resId)
            .also {
                startAnimation(it)
            }
}

private fun View.inAnimation(resId: Int): Animation? {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
        return loadAnimation(resId)
    }
    return null
}

private fun View.outAnimation(resId: Int): Animation? {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
        return loadAnimation(resId)
    }
    return null
}

fun View.translateAnimation(
        fromXDelta: Float, toXDelta: Float,
        fromYDelta: Float, toYDelta: Float,
        duration: Long = 300,
        listener: Animation.AnimationListener? = null
): Animation {
    cancelAnimation()
    return TranslateAnimation(
            fromXDelta, toXDelta,
            fromYDelta, toYDelta)
            .apply {
                this.duration = duration
                interpolator = DecelerateInterpolator()
                setAnimationListener(listener)
            }
            .also {
                startAnimation(it)
            }
}

fun View.alphaAnimation(
        fromAlpha: Float, toAlpha: Float,
        duration: Long = 300,
        listener: Animation.AnimationListener? = null
): Animation {
    cancelAnimation()
    return AlphaAnimation(fromAlpha, toAlpha)
            .apply {
                this.duration = duration
                setAnimationListener(listener)
            }
            .also {
                startAnimation(it)
            }
}

// endregion

// region Animation Set

fun View.flipLeftInAnimation() = loadAnimator(R.animator.flip_left_in)
fun View.flipLeftOutAnimation() = loadAnimator(R.animator.flip_left_out)
fun View.flipRightInAnimation() = loadAnimator(R.animator.flip_right_in)
fun View.flipRightOutAnimation() = loadAnimator(R.animator.flip_right_out)

fun View.loadAnimator(resId: Int): AnimatorSet {
    cancelAnimation()
    return (AnimatorInflater.loadAnimator(context, resId) as AnimatorSet)
            .apply {
                setTarget(this@loadAnimator)
                start()
            }
}

fun View.zoomInOutAnimation(toScale: Float, duration: Long = 600) {
    cancelAnimation()
    val animationScaleUp = ScaleAnimation(
            scaleX,
            scaleX * toScale,
            scaleY,
            scaleY * toScale)
    val animationScaleDown = ScaleAnimation(
            scaleX * toScale,
            scaleX,
            scaleY * toScale,
            scaleY)

    AnimationSet(false)
            .apply {
                this.duration = duration
                addAnimation(animationScaleUp)
                addAnimation(animationScaleDown)
            }
            .also {
                startAnimation(it)
            }
}

fun View.moveAndScaleAnimation(srcRect: Rect, destRect: Rect, duration: Long = 300, interpolator: Interpolator = DecelerateInterpolator(), listener: Animation.AnimationListener? = null) {
    cancelAnimation()

    val lScaleX = (destRect.width() / srcRect.width()).toFloat()
    val lScaleY = (destRect.height() / srcRect.height()).toFloat()
    val lTranslateX = (destRect.centerX() - srcRect.centerX()).toFloat()
    val lTranslateY = (destRect.centerY() - srcRect.centerY()).toFloat()

    val lScaleAnimation = ScaleAnimation(1f, lScaleX, 1f, lScaleY)
    val lTranslateAnimation = TranslateAnimation(0f,
            lTranslateX,
            0f,
            lTranslateY)

    AnimationSet(true)
            .apply {
                this.interpolator = interpolator
                this.duration = duration
                addAnimation(lScaleAnimation)
                addAnimation(lTranslateAnimation)
                setAnimationListener(listener)
            }
            .also {
                startAnimation(it)
            }
}

fun View.moveAndScaleReverseAnimation(pSrcRect: Rect, pDestRect: Rect, duration: Long = 300, interpolator: Interpolator = DecelerateInterpolator(), listener: Animation.AnimationListener? = null) {
    cancelAnimation()

    val lScaleX = (pDestRect.width() / pSrcRect.width()).toFloat()
    val lScaleY = (pDestRect.height() / pSrcRect.height()).toFloat()
    val lTranslateX = (pDestRect.centerX() - pSrcRect.centerX()).toFloat()
    val lTranslateY = (pDestRect.centerY() - pSrcRect.centerY()).toFloat()

    val lScaleAnimation = ScaleAnimation(1 / lScaleX, 1f, 1 / lScaleY, 1f)
    val lTranslateAnimation = TranslateAnimation(
            -lTranslateX,
            0f,
            -lTranslateY,
            0f)

    AnimationSet(true)
            .apply {
                this.interpolator = interpolator
                this.duration = duration
                addAnimation(lScaleAnimation)
                addAnimation(lTranslateAnimation)
                setAnimationListener(listener)
            }
            .also {
                startAnimation(it)
            }
}

// endregion
