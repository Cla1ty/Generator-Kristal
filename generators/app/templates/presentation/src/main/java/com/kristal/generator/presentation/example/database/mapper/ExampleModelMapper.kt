package <%= appPackage %>.presentation.example.database.mapper

import android.content.Context
import android.support.v4.content.ContextCompat
import <%= appPackage %>.domain.example.Example
import <%= appPackage %>.presentation.example.database.model.ExampleModel
import <%= appPackage %>.tool.R
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/14/17.
 */

@Singleton
class ExampleModelMapper
@Inject internal constructor(
        val context: Context
) {
    fun transform(example: Example): ExampleModel =
            ExampleModel(example.id, example.message, getColor(example.id))

    fun transform(example: List<Example>): List<ExampleModel> =
            example.map { ExampleModel(it.id, it.message, getColor(it.id)) }


    fun getColor(id: String) =
            when (id) {
                "a" -> ContextCompat.getColor(context, R.color.yellow_700)
                "b" -> ContextCompat.getColor(context, R.color.blue_900)
                "c" -> ContextCompat.getColor(context, R.color.brown_700)
                "d" -> ContextCompat.getColor(context, R.color.indigo_900)
                "e" -> ContextCompat.getColor(context, R.color.indigo_700)
                "f" -> ContextCompat.getColor(context, R.color.light_blue_900)
                "g" -> ContextCompat.getColor(context, R.color.deep_purple_700)
                "h" -> ContextCompat.getColor(context, R.color.red_900)
                "i" -> ContextCompat.getColor(context, R.color.grey_700)
                "j" -> ContextCompat.getColor(context, R.color.purple_900)
                "k" -> ContextCompat.getColor(context, R.color.blue_700)
                "l" -> ContextCompat.getColor(context, R.color.teal_900)
                "m" -> ContextCompat.getColor(context, R.color.cyan_700)
                "n" -> ContextCompat.getColor(context, R.color.lime_900)
                "o" -> ContextCompat.getColor(context, R.color.indigo_700)
                "p" -> ContextCompat.getColor(context, R.color.pink_900)
                "q" -> ContextCompat.getColor(context, R.color.yellow_700)
                "r" -> ContextCompat.getColor(context, R.color.deep_purple_900)
                "s" -> ContextCompat.getColor(context, R.color.light_blue_700)
                "t" -> ContextCompat.getColor(context, R.color.orange_700)
                "u" -> ContextCompat.getColor(context, R.color.green_900)
                "v" -> ContextCompat.getColor(context, R.color.purple_700)
                "w" -> ContextCompat.getColor(context, R.color.brown_900)
                "x" -> ContextCompat.getColor(context, R.color.teal_700)
                "y" -> ContextCompat.getColor(context, R.color.grey_900)
                else -> ContextCompat.getColor(context, R.color.brown_700)
            }

}
