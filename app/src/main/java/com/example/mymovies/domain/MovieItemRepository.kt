package com.example.mymovies.domain

import androidx.lifecycle.LiveData

interface MovieItemRepository {

    suspend fun getMovieItemList(page : Int) : List<MovieItem>

    suspend fun getFavouriteMovieItemList() : List<MovieItem>

    suspend fun getFavouriteMovieItem(movieId : Int) : MovieItem?

    suspend fun addFavouriteMovie(movieItem: MovieItem)

    suspend fun removeFavouriteMovie(movieItem: MovieItem)
}