package com.kristal.kbbi.presentation.view.common

import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText

/**
 * Created by Dwi_Ari on 10/28/17.
 */

class EditTextSearchSupport(
        editText: EditText,
        private val searchQuery: (String) -> Unit
) : TextWatcher {
    private val handler = Handler()
    private var runnable: Runnable? = null

    private var delay: Long = 1000

    init {
        editText.addTextChangedListener(this)
    }

    override fun afterTextChanged(s: Editable?) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (runnable != null) {
            handler.removeCallbacks(runnable)
            runnable = null
        }

        if (TextUtils.isEmpty(s)) return

        runnable = Runnable {
            searchQuery.invoke(s.toString())
        }
        handler.postDelayed(runnable, delay)
    }
}