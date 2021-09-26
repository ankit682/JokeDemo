package com.example.jokedemoapplication.data.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("id")
    val id: String?,
    @SerializedName("joke")
    val joke: String?
)
