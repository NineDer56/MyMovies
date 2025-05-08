package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.repository.MovieItemRepository

class AddFavouriteMovieUseCase(
    private val repository: MovieItemRepository
) {
    suspend fun addFavouriteMovie(movie: MovieItem){
        repository.addFavouriteMovie(movie)
    }
}