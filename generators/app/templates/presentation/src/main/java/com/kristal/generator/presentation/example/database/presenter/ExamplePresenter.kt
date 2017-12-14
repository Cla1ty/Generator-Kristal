package <%= appPackage %>.presentation.example.database.presenter

import <%= appPackage %>.domain.interactor.base.DefaultDisposableObserver
import <%= appPackage %>.domain.example.raw.interactor.GetExamples
import <%= appPackage %>.presentation.example.database.mapper.ExampleModelMapper
import <%= appPackage %>.presentation.presenter.base.BasePresenter
import <%= appPackage %>.presentation.example.database.view.ExampleView
import <%= appPackage %>.presentation.example.database.view.fragment.ExampleFragment
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/15/17.
 */

class ExamplePresenter
@Inject internal constructor(
        fragment: ExampleFragment,
        private val alphabets: GetExamples,
        private val exampleMapper: ExampleModelMapper
) : BasePresenter<ExampleView>(fragment) {

    override fun start() {
        super.start()
        view.showLoading()
        alphabets.execute(DefaultDisposableObserver(
                next = {
                    view.renderView(exampleMapper.transform(it))
                },
                error = {
                    view.showError(it.message!!)
                },
                complete = {
                    view.hideLoading()
                }

        ), null)
    }
}
