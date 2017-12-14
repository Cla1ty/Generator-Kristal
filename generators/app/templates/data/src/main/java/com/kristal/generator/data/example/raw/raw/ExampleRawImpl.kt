package <%= appPackage %>.data.example.raw.raw

import android.text.TextUtils
import <%= appPackage %>.data.R
import <%= appPackage %>.data.example.file.file.entity.ExampleListEntity
import <%= appPackage %>.data.example.file.file.mapper.serializer.Serializer
import <%= appPackage %>.data.example.raw.raw.tools.RawManager
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Dwi_Ari on 10/13/17.
 */

class ExampleRawImpl
@Inject internal constructor(
        private val rawManager: RawManager,
        private val serializer: Serializer
) : ExampleRaw {
    private val rawData = R.raw.data_install

    override fun alphabetEntityList(): Observable<ExampleListEntity> =
            Observable.create {
                val json = rawManager.readRawContent(rawData)

                if (TextUtils.isEmpty(json)) run {
                    it.onError(Throwable("Null Pointer"))
                    it.onComplete()
                    return@create
                }

                val data = serializer
                        .deserialize(
                                json!!,
                                ExampleListEntity::class.java
                        )

                it.onNext(data)
                it.onComplete()
            }
}
