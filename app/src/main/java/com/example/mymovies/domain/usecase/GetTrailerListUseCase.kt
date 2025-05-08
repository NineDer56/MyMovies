package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.repository.MovieItemRepository
import com.example.mymovies.domain.dto.trailer.Trailer

class GetTrailerListUseCase(
    private val repository: MovieItemRepository
) {
    suspend fun getTrailerList(movieId : Int) : List<Trailer>{
        return repository.getTrailerList(movieId)
    }
}