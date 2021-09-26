package com.example.jokedemoapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JokeResult {

    @SerializedName("current_page")
    @Expose
    var currentPage: Int? = null

    @SerializedName("limit")
    @Expose
    var limit: Int? = null

    @SerializedName("next_page")
    @Expose
    var nextPage: Int? = null

    @SerializedName("previous_page")
    @Expose
    var previousPage: Int? = null

    @SerializedName("results")
    @Expose
    var results: List<Joke>? = null

    @SerializedName("search_term")
    @Expose
    var searchTerm: String? = null

    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("total_jokes")
    @Expose
    var totalJokes: Int? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
}