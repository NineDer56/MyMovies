package com.example.mymovies.domain

class GetMovieItemUseCase(
    private val repository: MovieItemRepository
) {
    fun getMovieItem(movieId : Int) : MovieItem{
        return repository.getMovieItem(movieId)
    }
}