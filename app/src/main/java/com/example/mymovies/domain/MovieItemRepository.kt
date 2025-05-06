package com.example.mymovies.domain

interface MovieItemRepository {

    suspend fun getMovieItemList(page : Int) : List<MovieItem>

    suspend fun getFavouriteMovieItemList() : List<MovieItem>

    suspend fun addFavouriteMovie(movieItem: MovieItem)
}