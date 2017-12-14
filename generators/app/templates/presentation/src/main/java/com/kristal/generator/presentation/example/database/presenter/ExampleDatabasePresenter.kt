package <%= appPackage %>.presentation.example.database.presenter

import <%= appPackage %>.domain.example.database.interactor.GetExamplesFromDatabase
import <%= appPackage %>.presentation.example.database.mapper.ExampleModelMapper
import <%= appPackage %>.presentation.presenter.base.BasePresenter
import <%= appPackage %>.presentation.example.database.view.ExampleView
import <%= appPackage %>.presentation.example.database.view.fragment.ExampleDatabaseFragment
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/23/17.
 */

class ExampleDatabasePresenter
@Inject internal constructor(
        fragment: ExampleDatabaseFragment,
        private val alphabets: GetExamplesFromDatabase,
        private val exampleMapper: ExampleModelMapper
) : BasePresenter<ExampleView>(fragment) {

    override fun start() {
        super.start()
        view.showLoading()
        alphabets.execute(
                {
                    view.hideLoading()
                    view.renderView(exampleMapper.transform(it))
                },
                {
                    view.showError(it.message!!)
                }
                , "a")
    }
}
