package <%= appPackage %>.tool.extensions

import <%= appPackage %>.tool.MathHelper

/**
 * Created by Kristal on 09/08/2017.
 */

val Int.dp: Int
    get() = MathHelper.dp2Px(toFloat()).toInt()
