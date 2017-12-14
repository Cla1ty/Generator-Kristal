package <%= appPackage %>.presentation.example.database.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Dwi_Ari on 10/14/17.
 */

class ExampleModel(val id: String, val message: String, val color: Int) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(message)
        writeInt(color)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ExampleModel> = object : Parcelable.Creator<ExampleModel> {
            override fun createFromParcel(source: Parcel): ExampleModel = ExampleModel(source)
            override fun newArray(size: Int): Array<ExampleModel?> = arrayOfNulls(size)
        }
    }
}
