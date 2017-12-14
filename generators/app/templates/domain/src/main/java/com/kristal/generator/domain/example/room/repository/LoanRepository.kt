package <%= appPackage %>.domain.example.room.repository

import <%= appPackage %>.domain.example.room.LoanComplete
import io.reactivex.Flowable

/**
 * Created by Dwi_Ari on 11/17/17.
 */

interface LoanRepository {
    fun findAllLoan(): Flowable<List<LoanComplete>>
}
