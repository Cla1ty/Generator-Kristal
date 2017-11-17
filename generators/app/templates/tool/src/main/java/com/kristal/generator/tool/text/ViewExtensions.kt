package <%= appPackage %>.tool.text

import android.view.View

/**
 * Created by Dwi_Ari on 11/17/17.
 */

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

