package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.repository.MovieItemRepository

class GetMovieItemListUseCase(
    private val repository: MovieItemRepository
) {
    suspend operator fun invoke(page: Int): List<MovieItem> =
        repository.getMovieItemList(page)
}