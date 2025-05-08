package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.repository.MovieItemRepository

class GetMovieItemListUseCase(
    private val repository: MovieItemRepository
) {
    suspend fun getMovieItemList(page : Int) : List<MovieItem> {
        return repository.getMovieItemList(page)
    }
}