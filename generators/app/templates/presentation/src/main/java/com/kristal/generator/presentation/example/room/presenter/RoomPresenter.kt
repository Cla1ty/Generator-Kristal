package <%= appPackage %>.presentation.example.room.presenter

import android.arch.lifecycle.ViewModelProviders
import <%= appPackage %>.presentation.example.room.mapper.toLoanCompleteModel
import <%= appPackage %>.presentation.example.room.view.RoomView
import <%= appPackage %>.presentation.example.room.view.fragment.RoomFragment
import <%= appPackage %>.presentation.example.room.view.viewmodel.BookViewModel
import <%= appPackage %>.presentation.example.room.view.viewmodel.factory.ViewModelFactory
import <%= appPackage %>.presentation.presenter.base.BasePresenter
import <%= appPackage %>.tool.recyclerview.adapter.data.StringData
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class RoomPresenter
@Inject constructor(
        private val factory: ViewModelFactory,
        private val fragment: RoomFragment
) : BasePresenter<RoomView>(fragment) {

    lateinit var viewModel: BookViewModel

    override fun start() {
        super.start()

        view.showLoading()

        viewModel = ViewModelProviders.of(fragment, factory)
                .get(BookViewModel::class.java)

        viewModel.findAllLoan()
                .execute(
                        {
                            view.renderView(
                                    it.map {
                                        it.toLoanCompleteModel()
                                                .let {
                                                    StringData("${it.title} : ${it.name}")
                                                }
                                    }
                            )
                            view.hideLoading()
                        },
                        {
                            view.showRetry()
                        })
//                        ,
//                        "Mike")

    }

}
