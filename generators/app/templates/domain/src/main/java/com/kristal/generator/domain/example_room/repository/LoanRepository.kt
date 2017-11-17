package <%= appPackage %>.domain.example_room.repository

import <%= appPackage %>.domain.example_room.LoanComplete
import io.reactivex.Flowable

/**
 * Created by Dwi_Ari on 11/17/17.
 */

interface LoanRepository {
    fun findAllLoan(): Flowable<List<LoanComplete>>
}
