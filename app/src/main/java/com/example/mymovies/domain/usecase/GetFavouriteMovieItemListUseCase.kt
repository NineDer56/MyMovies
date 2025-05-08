package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieItem
import com.example.mymovies.domain.MovieItemRepository

class GetFavouriteMovieItemListUseCase(
    private val repository: MovieItemRepository
) {

    suspend fun getFavouriteMovieItemList() : List<MovieItem> {
        return repository.getFavouriteMovieItemList()
    }
}