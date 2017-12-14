package <%= appPackage %>.presentation.example.room.view.viewmodel

import android.arch.lifecycle.ViewModel
import <%= appPackage %>.domain.example.room.interactor.FindAllLoan
import <%= appPackage %>.domain.example.room.interactor.FindBooksBorrowedByName

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
