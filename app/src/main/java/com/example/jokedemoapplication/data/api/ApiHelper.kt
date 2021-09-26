package com.example.jokedemoapplication.data.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.jokedemoapplication.data.model.Joke
import com.example.jokedemoapplication.data.model.JokeResult
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {

    private val jokeList = MutableLiveData<List<Joke>>()

    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiService {
            Log.e("retrofit", "create")
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://icanhazdadjoke.com/")
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

    fun loadJokeData(): MutableLiveData<List<Joke>> {
        Log.e("loadJokeData()", "yes")
        val retrofitCall = create().getJokesWithId("application/json", "20")

        retrofitCall.enqueue(object : Callback<JokeResult> {
            override fun onFailure(call: Call<JokeResult>, t: Throwable?) {
                if (t != null) {
                    Log.e("on Failure :", "${t.cause}retrofit error")
                }
            }

            override fun onResponse(call: Call<JokeResult>, response: Response<JokeResult>) {
                val joke = response.body()
                Log.e("LOG FOR JOKE", "${response.raw().request().url()}")

                if (joke != null) {
                    jokeList.value = joke.results
                }
            }
        })
        return jokeList
    }
}