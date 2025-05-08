package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.repository.MovieItemRepository

class GetFavouriteMovieItemListUseCase(
    private val repository: MovieItemRepository
) {

    suspend fun getFavouriteMovieItemList() : List<MovieItem> {
        return repository.getFavouriteMovieItemList()
    }
}