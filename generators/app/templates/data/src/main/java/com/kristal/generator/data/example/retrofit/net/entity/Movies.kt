package com.kristal.mymovie.network.model

import com.google.gson.annotations.SerializedName

internal class Movies {

    @SerializedName("page")
    var page: Int = 0

    @SerializedName("total_pages")
    var totalPages: Int = 0

//    @SerializedName("results")
//    var results: List<MovieItem>? = null

    @SerializedName("total_results")
    var totalResults: Int = 0

    override fun toString(): String {
        return "Movies{" +
                "page = '" + page + '\'' +
                ",total_pages = '" + totalPages + '\'' +
//                ",results = '" + results + '\'' +
                ",total_results = '" + totalResults + '\'' +
                "}"
    }
}