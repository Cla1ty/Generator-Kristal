package <%= appPackage %>.domain.repository

/**
 * Created by Dwi_Ari on 10/19/17.
 */

interface ApplicationRepository {
    var lang:Int

    companion object {
        val NONE = 0
        val INDO = 1
        val UK = 2
    }
}
