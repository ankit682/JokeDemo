package com.example.jokedemoapplication.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jokedemoapplication.R
import com.example.jokedemoapplication.data.model.Joke
import com.example.jokedemoapplication.ui.main.adapter.JokeAdapter
import com.example.jokedemoapplication.ui.main.viewmodel.JokeViewModel
import kotlinx.android.synthetic.main.activity_joke.*

class JokeActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        setUpUi()
        setObserver()
    }

    private fun setUpUi() {

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.hasFixedSize()

        new_joke_button.setOnClickListener {
            setObserver()
            recycler_view.adapter?.notifyDataSetChanged()
        }
    }

    private fun setObserver() {

        val mAndroidViewModel = ViewModelProviders.of(this).get(JokeViewModel::class.java)
        Log.e("Set Observer, ViewModel", mAndroidViewModel.toString());
        mAndroidViewModel.getJokeData()
            ?.observe(this, Observer<List<Joke>> { androidList ->
                Log.e("list", androidList.size.toString())
                progress_bar.visibility = View.GONE
                linear_view.visibility = View.VISIBLE
                new_joke_button.visibility = View.VISIBLE
                recycler_view.adapter = JokeAdapter(androidList as ArrayList<Joke>);
            })
    }
}