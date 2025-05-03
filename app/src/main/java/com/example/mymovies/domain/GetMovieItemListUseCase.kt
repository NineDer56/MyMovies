package com.example.mymovies.domain

class GetMovieItemListUseCase(
    private val repository: MovieItemRepository
) {
    suspend fun getMovieItemList(page : Int) : List<MovieItem> {
        return repository.getMovieItemList(page)
    }
}