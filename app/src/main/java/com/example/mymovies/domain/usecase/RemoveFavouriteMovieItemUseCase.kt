package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieItem
import com.example.mymovies.domain.MovieItemRepository

class RemoveFavouriteMovieItemUseCase(
    private val repository: MovieItemRepository
) {

    suspend fun removeFavouriteMovieItem(movie: MovieItem){
        repository.removeFavouriteMovie(movie)
    }
}