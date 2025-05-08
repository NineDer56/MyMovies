package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieItemRepository
import com.example.mymovies.domain.Trailer

class GetTrailerListUseCase(
    private val repository: MovieItemRepository
) {
    suspend fun getTrailerList(movieId : Int) : List<Trailer>{
        return repository.getTrailerList(movieId)
    }
}