package <%= appPackage %>.tool.extensions

/**
 * Created by Kristal on 6/8/2017.
 */

val Any.name: String
    get() = this::class.java.simpleName
