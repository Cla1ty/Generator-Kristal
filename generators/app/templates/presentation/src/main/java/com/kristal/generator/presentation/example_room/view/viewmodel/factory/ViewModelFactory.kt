package <%= appPackage %>.presentation.example_room.view.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import <%= appPackage %>.domain.example_room.interactor.FindAllLoan
import <%= appPackage %>.domain.example_room.interactor.FindBooksBorrowedByName
import <%= appPackage %>.presentation.example_room.view.viewmodel.BookViewModel
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class ViewModelFactory
@Inject constructor(
        private val book: FindBooksBorrowedByName,
        private val loan: FindAllLoan
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
            return BookViewModel(book, loan) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
