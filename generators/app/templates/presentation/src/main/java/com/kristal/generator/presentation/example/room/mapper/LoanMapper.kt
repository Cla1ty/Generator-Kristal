package <%= appPackage %>.presentation.example.room.mapper

import <%= appPackage %>.domain.example.room.LoanComplete
import <%= appPackage %>.presentation.example.room.model.LoanCompleteModel

/**
 * Created by Dwi_Ari on 11/17/17.
 */

fun LoanComplete.toLoanCompleteModel():
        LoanCompleteModel = LoanCompleteModel(id, title, name, startTime, endTime)
