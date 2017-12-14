package <%= appPackage %>.domain.example.room

import java.util.*

/**
 * Created by Dwi_Ari on 11/17/17.
 */

data class LoanComplete(
        val id: String,
        val title: String,
        val name: String,
        val startTime: Date,
        val endTime: Date
)
