package <%= appPackage %>.data.example_room.repository

import <%= appPackage %>.data.example_room.db.dao.LoanDao
import <%= appPackage %>.data.example_room.db.mapper.toLoanComplete
import <%= appPackage %>.domain.example_room.LoanComplete
import <%= appPackage %>.domain.example_room.repository.LoanRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 11/17/17.
 */

class LoanRepositoryImpl
@Inject constructor(
        private val dao: LoanDao
) : LoanRepository {
    override fun findAllLoan():
            Flowable<List<LoanComplete>> = dao.findAllWithUserAndBook().map { it.map { it.toLoanComplete() } }
}
