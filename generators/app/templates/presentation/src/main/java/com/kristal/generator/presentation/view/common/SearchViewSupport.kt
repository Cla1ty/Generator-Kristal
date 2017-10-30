package com.kristal.kbbi.presentation.view.common

import android.os.Handler
import android.support.v7.widget.SearchView
import android.text.TextUtils

/**
 * Created by Kristal on 9/17/17.
 */

class SearchViewSupport
constructor(
        searchView: SearchView,
        hint: CharSequence,
        delay: Long,
        private val searchQuery: (String) -> Unit
) : SearchView.OnQueryTextListener {

    private val handler = Handler()
    private var runnable: Runnable? = null

    private var delay: Long = 2000
    private var alreadySearched = false

    init {
        searchView.queryHint = hint
        searchView.setOnQueryTextListener(this)

        if (delay > 0)
            this.delay = delay
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        removeCallback()
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        removeCallback()

        if (TextUtils.isEmpty(newText)) return false

        alreadySearched = false

        runnable = Runnable { search(newText) }
        handler.postDelayed(runnable, delay)

        return true
    }

    private fun removeCallback() {
        if (runnable != null) {
            handler.removeCallbacks(runnable)
            runnable = null
        }
    }

    private fun search(query: String) {
        if (alreadySearched) return
        alreadySearched = true

        searchQuery.invoke(query)
    }
}
