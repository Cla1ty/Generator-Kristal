package <%= appPackage %>.domain.example.room

import java.util.*

/**
 * Created by Dwi_Ari on 11/16/17.
 */

data class Loan(
        val id: String,
        val startTime: Date,
        val endTime: Date,
        val bookId: String,
        val userId: String
)
