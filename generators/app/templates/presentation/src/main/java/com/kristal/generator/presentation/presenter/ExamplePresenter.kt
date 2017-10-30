package <%= appPackage %>.presentation.presenter

import <%= appPackage %>.domain.interactor.base.DefaultDisposableObserver
import <%= appPackage %>.domain.interactor.GetExamples
import <%= appPackage %>.presentation.mapper.ExampleModelMapper
import <%= appPackage %>.presentation.presenter.base.BasePresenter
import <%= appPackage %>.presentation.view.ExampleView
import <%= appPackage %>.presentation.view.fragment.ExampleFragment
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
