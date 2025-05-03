package com.example.mymovies.domain

import androidx.lifecycle.LiveData

interface MovieItemRepository {

    fun getMovieItem(movieId: Int) : MovieItem

    fun getMovieItemList() : LiveData<List<MovieItem>>

}