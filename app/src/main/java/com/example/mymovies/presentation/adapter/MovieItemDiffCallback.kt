package com.example.mymovies.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mymovies.domain.dto.movie.MovieItem

class MovieItemDiffCallback : DiffUtil.ItemCallback<MovieItem>() {
    override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem == newItem
    }
}