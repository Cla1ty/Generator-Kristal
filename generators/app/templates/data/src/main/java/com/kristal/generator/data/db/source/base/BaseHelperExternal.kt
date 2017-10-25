package <%= appPackage %>.data.db.source.base

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.File
import java.io.FileOutputStream

/**
 * Created by Dwi_Ari on 10/23/17.
 */

internal abstract class BaseHelperExternal
constructor(
        context: Context,
        assetName: String
) : SQLiteOpenHelper(context, null, null, 1) {
    private val PATH = context.filesDir.path + assetName
    private val exists
        get() = File(PATH).exists()

    private var database: SQLiteDatabase? = null

    init {
        if (!exists) {
            val inputStream = context.assets.open(assetName)
            val outputStream = FileOutputStream(PATH)
            val buffer = ByteArray(2024)
            var mLength: Int
            mLength = inputStream.read(buffer)
            while (mLength > 0) {
                outputStream.write(buffer, 0, mLength)
                mLength = inputStream.read(buffer)
            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {}
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    override fun getWritableDatabase(): SQLiteDatabase =
            SQLiteDatabase.openDatabase(PATH, null, SQLiteDatabase.OPEN_READWRITE)
                    .also { database = it }

    override fun getReadableDatabase(): SQLiteDatabase =
            SQLiteDatabase.openDatabase(PATH, null, SQLiteDatabase.OPEN_READONLY)
                    .also { database = it }

    override fun close() {
        super.close()
        database?.close()
    }

    private fun dbDelete() {
        if (exists) {
            File(PATH).delete()
        }
    }
}
