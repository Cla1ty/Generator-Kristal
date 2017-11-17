package <%= appPackage %>.presentation.example_room.view.viewmodel

import android.arch.lifecycle.ViewModel
import <%= appPackage %>.domain.example_room.interactor.FindAllLoan
import <%= appPackage %>.domain.example_room.interactor.FindBooksBorrowedByName

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class BookViewModel(
        private val book: FindBooksBorrowedByName,
        private val loan: FindAllLoan
) : ViewModel() {
    fun findBooksBorrowedByName() = book
    fun findAllLoan() = loan
}
