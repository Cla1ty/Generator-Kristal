package <%= appPackage %>.presentation.example_room.model

import <%= appPackage %>.tool.recyclerview.adapter.RecyclerViewData

/**
 * Created by Dwi_Ari on 11/17/17.
 */

data class BookModel(
        val id: String,
        val title: String
) : RecyclerViewData {
    override fun isSameId(otherData: RecyclerViewData):
            Boolean = otherData is BookModel && otherData.id == id

    override fun isSameData(otherData: RecyclerViewData):
            Boolean = false
}
