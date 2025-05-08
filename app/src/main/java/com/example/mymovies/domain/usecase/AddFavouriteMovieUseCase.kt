package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieItem
import com.example.mymovies.domain.MovieItemRepository

class AddFavouriteMovieUseCase(
    private val repository: MovieItemRepository
) {
    suspend fun addFavouriteMovie(movie: MovieItem){
        repository.addFavouriteMovie(movie)
    }
}