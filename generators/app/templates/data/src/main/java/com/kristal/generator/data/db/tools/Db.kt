package <%= appPackage %>.data.db.tools

import android.database.Cursor

/**
 * Created by Kristal on 9/26/17.
 */

internal object Db {
    private val BOOLEAN_FALSE = 0
    private val BOOLEAN_TRUE = 1

    fun getString(cursor: Cursor, columnName: String): String =
            cursor.getString(cursor.getColumnIndexOrThrow(columnName))

    fun getBoolean(cursor: Cursor, columnName: String): Boolean =
            getInt(cursor, columnName) == BOOLEAN_TRUE

    fun getLong(cursor: Cursor, columnName: String): Long =
            cursor.getLong(cursor.getColumnIndexOrThrow(columnName))

    fun getInt(cursor: Cursor, columnName: String): Int =
            cursor.getInt(cursor.getColumnIndexOrThrow(columnName))

    fun getDouble(cursor: Cursor, columnName: String): Double =
            cursor.getDouble(cursor.getColumnIndexOrThrow(columnName))
}