package com.example.jokedemoapplication.data.api

import com.example.jokedemoapplication.data.model.JokeResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("/search")
    fun getJokesWithId(
        @Header("Accept") someHeader: String,
        @Query("limit") limit: String
    ): Call<JokeResult>

//    @GET("api")
//    fun getJokes(@Query(";") format: String): Response<List<Joke>>
}