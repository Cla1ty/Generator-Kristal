package <%= appPackage %>.domain.interactor.base

/**
 * Created by Dwi_Ari on 10/28/17.
 */

class DefaultObservable<in DATA>(
        val next: (DATA) -> Unit,
        val error: (Throwable) -> Unit,
        val complete: () -> Unit)