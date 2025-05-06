package com.example.mymovies.domain

class AddFavouriteMovieUseCase(
    private val repository: MovieItemRepository
) {
    suspend fun addFavouriteMovie(movie: MovieItem){
        repository.addFavouriteMovie(movie)
    }
}