package <%= appPackage %>.data.repository

import <%= appPackage %>.data.mapper.ExampleListEntityMapper
import <%= appPackage %>.data.repository.source.ExampleSourceFactory
import <%= appPackage %>.domain.Example
import <%= appPackage %>.domain.repository.ExampleRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/13/17.
 */

@Singleton
class ExampleRepositoryImpl
@Inject internal constructor(
        private val factory: ExampleSourceFactory,
        private val mapper: ExampleListEntityMapper
) : ExampleRepository {
    override fun examples(): Observable<List<Example>> =
            factory.create().alphabetListEntity().map { mapper.transform(it) }
}
