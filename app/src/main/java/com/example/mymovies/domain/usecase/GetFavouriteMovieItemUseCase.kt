package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.repository.MovieItemRepository

class GetFavouriteMovieItemUseCase(
    private val repository: MovieItemRepository
) {

    suspend fun getFavouriteMovieItem(movieId : Int) : MovieItem? {
        return repository.getFavouriteMovieItem(movieId)
    }

}