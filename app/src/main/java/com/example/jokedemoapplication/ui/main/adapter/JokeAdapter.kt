package com.example.jokedemoapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jokedemoapplication.R
import com.example.jokedemoapplication.data.model.Joke
import kotlinx.android.synthetic.main.adapter_joke.view.*

class JokeAdapter(private val jokes: ArrayList<Joke>) :
    RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(joke: Joke) {
            itemView.joke_text_view.text = joke.joke
//            itemView.url_text_view.text = joke.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_joke, parent, false)
        )
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        return holder.bind(jokes[position])
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    fun setJoke(joke: List<Joke>) {
        jokes.addAll(joke)
    }
}