package <%= appPackage %>.data.example.database.db.entity

/**
 * Created by Dwi_Ari on 10/30/17.
 */

/**
 * Created by Dwi_Ari on 10/28/17.
 */

data class ExampleEntity(
        val kata: String,
        val makna: String,
        val dateCreate: String,
        val dateUpdate: String
) {
    companion object {
        val KATA = "Kata"
        val MAKNA = "Makna"
        val DATE_CREATE = "Datecreate"
        val DATE_UPDATE = "Dateupdate"
    }
}
