package <%= appPackage %>.presentation.view

import <%= appPackage %>.presentation.model.ExampleModel
import <%= appPackage %>.presentation.view.base.LoadDataView

/**
 * Created by Dwi_Ari on 10/15/17.
 */

interface ExampleView : LoadDataView {
    fun renderView(datas: List<ExampleModel>)
}
