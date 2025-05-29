package com.example.mymovies.domain.repository

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.dto.review.Review
import com.example.mymovies.domain.dto.trailer.Trailer

interface MovieItemRepository {

    suspend fun getMovieItemList(page : Int) : List<MovieItem>

    suspend fun getFavouriteMovieItemList() : List<MovieItem>

    suspend fun getFavouriteMovieItem(movieId : Int) : MovieItem?

    suspend fun addFavouriteMovie(movieItem: MovieItem)

    suspend fun removeFavouriteMovie(movieItem: MovieItem)
}