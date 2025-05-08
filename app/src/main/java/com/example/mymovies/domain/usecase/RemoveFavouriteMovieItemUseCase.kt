package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.repository.MovieItemRepository

class RemoveFavouriteMovieItemUseCase(
    private val repository: MovieItemRepository
) {

    suspend fun removeFavouriteMovieItem(movie: MovieItem){
        repository.removeFavouriteMovie(movie)
    }
}