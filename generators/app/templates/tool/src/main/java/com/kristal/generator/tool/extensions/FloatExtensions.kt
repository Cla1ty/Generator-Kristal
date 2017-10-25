package <%= appPackage %>.tool.extensions

import <%= appPackage %>.tool.MathHelper

/**
 * Created by Kristal on 09/08/2017.
 */

val Float.dp: Float
    get() = MathHelper.dp2Px(this)
