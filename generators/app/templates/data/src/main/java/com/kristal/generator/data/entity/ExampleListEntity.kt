package <%= appPackage %>.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Dwi_Ari on 10/13/17.
 */

internal class ExampleListEntity {
    @SerializedName("data")
    var data: List<ExampleEntity>? = null
}
