package com.example.mymovies.domain

import androidx.lifecycle.LiveData

class GetFavouriteMovieItemListUseCase(
    private val repository: MovieItemRepository
) {

    suspend fun getFavouriteMovieItemList() : List<MovieItem> {
        return repository.getFavouriteMovieItemList()
    }
}