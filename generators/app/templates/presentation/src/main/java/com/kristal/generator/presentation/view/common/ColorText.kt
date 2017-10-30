package <%= appPackage %>.presentation.view.common

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import <%= appPackage %>.presentation.model.ExampleModel

/**
 * Created by Dwi_Ari on 10/20/17.
 */

class ColorText : TextView {
    constructor(context: Context?, model: ExampleModel) : super(context) {
        setup(model)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    fun setup(model: ExampleModel) {
        text = model.id.toString()
        textSize = 50f
        typeface = Typeface.DEFAULT_BOLD
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        }
        gravity = Gravity.CENTER

        setTextColor(model.color)
    }
}
