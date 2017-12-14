package <%= appPackage %>.presentation.example.room.model

import java.util.*

/**
 * Created by Dwi_Ari on 11/17/17.
 */

data class LoanCompleteModel(
        val id: String,
        val title: String,
        val name: String,
        val startTime: Date,
        val endTime: Date
)
