package com.example.jokedemoapplication.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jokedemoapplication.data.api.ApiHelper
import com.example.jokedemoapplication.data.model.Joke

class JokeViewModel : ViewModel() {
    private val apiHelper = ApiHelper()
    fun getJokeData(): MutableLiveData<List<Joke>>? {
        Log.e("getJokeData()", "yes")
        return apiHelper.loadJokeData()
    }
}