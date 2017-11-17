package <%= appPackage %>.presentation.example_room.view

import <%= appPackage %>.presentation.view.base.LoadDataView
import <%= appPackage %>.tool.recyclerview.adapter.data.StringData

/**
 * Created by Dwi_Ari on 11/17/17.
 */

interface RoomView : LoadDataView {
    fun renderView(datas: List<StringData>)
}
