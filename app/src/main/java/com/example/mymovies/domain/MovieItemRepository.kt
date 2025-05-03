package com.example.mymovies.domain

interface MovieItemRepository {

    suspend fun getMovieItemList(page : Int) : List<MovieItem>

}