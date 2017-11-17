package <%= appPackage %>.presentation.example_room.mapper

import <%= appPackage %>.domain.example_room.LoanComplete
import <%= appPackage %>.presentation.example_room.model.LoanCompleteModel

/**
 * Created by Dwi_Ari on 11/17/17.
 */

fun LoanComplete.toLoanCompleteModel():
        LoanCompleteModel = LoanCompleteModel(id, title, name, startTime, endTime)
