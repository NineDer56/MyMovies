package com.example.mymovies.domain

import androidx.lifecycle.LiveData

class GetMovieItemListUseCase(
    private val repository: MovieItemRepository
) {
    fun getMovieItemList() : LiveData<List<MovieItem>> {
        return repository.getMovieItemList()
    }
}