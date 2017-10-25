package <%= appPackage %>.presentation.presenter

import <%= appPackage %>.domain.interactor.DefaultObserver
import <%= appPackage %>.domain.interactor.GetExamplesFromDatabase
import <%= appPackage %>.presentation.mapper.ExampleModelMapper
import <%= appPackage %>.presentation.presenter.base.BasePresenter
import <%= appPackage %>.presentation.view.ExampleView
import <%= appPackage %>.presentation.view.fragment.ExampleDatabaseFragment
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
        alphabets.execute(DefaultObserver(
                next = {
                    view.hideLoading()

                    view.renderView(exampleMapper.transform(it))
                },
                error = {
                    view.showError(it.message!!)
                },
                complete = {
                    view.hideLoading()
                }

        ), "a")
    }
}
