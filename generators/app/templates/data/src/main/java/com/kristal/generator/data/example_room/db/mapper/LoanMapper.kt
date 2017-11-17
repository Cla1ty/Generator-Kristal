package <%= appPackage %>.data.example_room.db.mapper

import <%= appPackage %>.data.example_room.db.entity.LoanCompleteEntity
import <%= appPackage %>.domain.example_room.LoanComplete

/**
 * Created by Dwi_Ari on 11/17/17.
 */

fun LoanCompleteEntity.toLoanComplete():
        LoanComplete = LoanComplete(id, bookTitle, userName, startTime, endTime)
