package <%= appPackage %>.tool.recyclerview.adapter.data

import <%= appPackage %>.tool.recyclerview.adapter.RecyclerViewData

/**
 * Created by Dwi on 7/11/2017.
 */

class StringData(val string: String) : RecyclerViewData {

    override fun isSameId(otherData: RecyclerViewData): Boolean =
            otherData is StringData && otherData.string == string

    override fun isSameData(otherData: RecyclerViewData): Boolean =
            this == otherData
}
