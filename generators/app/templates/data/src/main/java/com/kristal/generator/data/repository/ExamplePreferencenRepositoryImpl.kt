package <%= appPackage %>.data.repository

import <%= appPackage %>.data.preference.ExamplePreference
import <%= appPackage %>.domain.repository.ApplicationRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/19/17.
 */

@Singleton
class ExamplePreferencenRepositoryImpl
@Inject internal constructor(
        private val preference: ExamplePreference
) : ApplicationRepository {
    override var lang: Int
        get() = preference.language
        set(value) {
            preference.language = value
        }
}
