package <%= appPackage %>.data.repository

import <%= appPackage %>.data.example.file.file.mapper.toListExample
import <%= appPackage %>.data.repository.source.ExampleSourceFactory
import <%= appPackage %>.domain.example.Example
import <%= appPackage %>.domain.example.raw.repository.ExampleRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/13/17.
 */

@Singleton
class ExampleRepositoryImpl
@Inject internal constructor(
        private val factory: ExampleSourceFactory
) : ExampleRepository {
    override fun examples(): Observable<List<Example>> =
            factory.create().alphabetListEntity().map { it.toListExample() }
}
