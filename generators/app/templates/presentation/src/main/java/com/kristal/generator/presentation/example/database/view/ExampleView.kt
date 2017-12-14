package <%= appPackage %>.presentation.example.database.view

import <%= appPackage %>.presentation.example.database.model.ExampleModel
import <%= appPackage %>.presentation.view.base.LoadDataView

/**
 * Created by Dwi_Ari on 10/15/17.
 */

interface ExampleView : LoadDataView<List<ExampleModel>>