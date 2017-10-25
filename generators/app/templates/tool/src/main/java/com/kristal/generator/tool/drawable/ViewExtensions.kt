package <%= appPackage %>.tool.drawable

import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView

/**
 * Created by Dwi_Ari on 10/24/17.
 */


fun View.setColorFilter(color: Int) {
    background ?: return
    background.mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN)
}

fun View.setColorResourceFilter(resColor: Int) {
    setColorFilter(ContextCompat.getColor(context, resColor))
}

fun ImageView.setColorFilter(color: Int) {
    drawable ?: return
    drawable.mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN)
}

fun ImageView.setColorResourceFilter(resColor: Int) {
    setColorFilter(ContextCompat.getColor(context, resColor))
}

fun View.setColorFilterMultiply(color: Int) {
    background ?: return
    background.mutate().setColorFilter(color, PorterDuff.Mode.MULTIPLY)
}

fun View.removeColorFilter() {
    background ?: return
    background.mutate().colorFilter = null
}

fun ImageView.removeColorFilter() {
    drawable ?: return
    drawable.mutate().colorFilter = null
}