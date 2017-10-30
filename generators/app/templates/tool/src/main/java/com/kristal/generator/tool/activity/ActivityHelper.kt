package <%= appPackage %>.tool.activity

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import <%= appPackage %>.tool.R


/**
 * Created by Dwi_Ari on 10/28/17.
 */

object ActivityHelper {
    fun hideKeyboardWhenTyping(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        if (inputMethodManager.isAcceptingText) {
            inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
        }
    }

    fun hideKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
    }

    fun copyText(context: Context, label: String, text: String) {
        val clipboard = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(label, text)
        clipboard.primaryClip = clip
        Toast.makeText(context, R.string.copy_clipboard, Toast.LENGTH_SHORT).show()
    }

    fun shareText(context: Context, subject: String, text: String) {
        Intent(Intent.ACTION_SEND)
                .apply {
                    type = "text/plain"
                    putExtra(android.content.Intent.EXTRA_TEXT, text);
                    putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                }.also {
            startActivity(context, Intent.createChooser(it, "Share using"), null)
        }
    }
}
