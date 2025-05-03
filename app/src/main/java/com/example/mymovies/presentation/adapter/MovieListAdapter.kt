package com.example.mymovies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.mymovies.R
import com.example.mymovies.domain.MovieItem
import java.math.RoundingMode
import java.util.Locale

class MovieListAdapter : ListAdapter<MovieItem, MovieViewHolder>(MovieItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item,
            parent,
            false
        )
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)

        holder.apply {
            Glide.with(holder.itemView.context).load(movie.poster.url).into(ivPoster)
            val imdbRating = movie.rating.imdbRating
            val kpRating = movie.rating.kpRating
            tvImdbRating.text = String.format(Locale.US,"%.1f", imdbRating)
            tvKpRating.text = String.format(Locale.US,"%.1f", kpRating)
        }
    }
}