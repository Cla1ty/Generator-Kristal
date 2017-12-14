package <%= appPackage %>.data.example.database.db.tools

import android.database.Cursor

/**
 * Created by Kristal on 9/26/17.
 */

internal object Db {
    private val BOOLEAN_FALSE = 0
    private val BOOLEAN_TRUE = 1

    fun getString(cursor: Cursor, columnName: String): String? {
        val column = cursor.getColumnIndex(columnName)
        return when (column) {
            -1 -> null
            else -> cursor.getString(column)
        }
    }

    fun getLong(cursor: Cursor, columnName: String): Long? {
        val column = cursor.getColumnIndex(columnName)
        return when (column) {
            -1 -> null
            else -> cursor.getLong(column)
        }
    }

    fun getInt(cursor: Cursor, columnName: String): Int? {
        val column = cursor.getColumnIndex(columnName)
        return when (column) {
            -1 -> null
            else -> cursor.getInt(column)
        }
    }

    fun getDouble(cursor: Cursor, columnName: String): Double? {
        val column = cursor.getColumnIndex(columnName)
        return when (column) {
            -1 -> null
            else -> cursor.getDouble(column)
        }
    }

    fun getBoolean(cursor: Cursor, columnName: String): Boolean =
            getInt(cursor, columnName) == BOOLEAN_TRUE
}