package <%= appPackage %>.presentation.utils

import <%= appPackage %>.presentation.example.database.model.ExampleModel

/**
 * Created by Dwi_Ari on 10/20/17.
 */

class AlphabetHelper(
        private var data: List<ExampleModel>,
        var currentData: ExampleModel
) {
    fun next(): ExampleModel {
        if (currentData.id == data[data.size - 1].id) {
            currentData = data[0]
            return currentData
        }

        var isNext = false
        for (model in data) {
            if (isNext) {
                currentData = model
                break
            }

            if (model.id == currentData.id) {
                isNext = true
            }
        }

        return currentData
    }

    fun previous(): ExampleModel {
        var previous = data[data.size - 1]

        for (model in data) {
            if (currentData.id == model.id) {
                currentData = previous
                break
            }

            previous = model
        }

        return currentData
    }
}
