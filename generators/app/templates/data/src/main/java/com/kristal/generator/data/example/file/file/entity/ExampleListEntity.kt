package <%= appPackage %>.data.example.file.file.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Dwi_Ari on 10/13/17.
 */

data class ExampleListEntity(
        @SerializedName("data")
        val data: List<ExampleEntity>
)
