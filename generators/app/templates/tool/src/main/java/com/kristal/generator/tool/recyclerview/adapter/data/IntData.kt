package <%= appPackage %>.tool.recyclerview.adapter.data

import <%= appPackage %>.tool.recyclerview.adapter.RecyclerViewData

/**
 * Created by Dwi on 7/12/2017.
 */

class IntData(val value: Int) : RecyclerViewData {
    override fun isSameId(otherData: RecyclerViewData): Boolean =
            otherData is IntData && value == otherData.value

    override fun isSameData(otherData: RecyclerViewData): Boolean =
            this == otherData
}
