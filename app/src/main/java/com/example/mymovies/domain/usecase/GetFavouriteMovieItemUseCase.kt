package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieItem
import com.example.mymovies.domain.MovieItemRepository

class GetFavouriteMovieItemUseCase(
    private val repository: MovieItemRepository
) {

    suspend fun getFavouriteMovieItem(movieId : Int) : MovieItem? {
        return repository.getFavouriteMovieItem(movieId)
    }

}