package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.trailer.Trailer
import com.example.mymovies.domain.repository.MovieItemRepository
import com.example.mymovies.domain.repository.TrailerRepository

class GetTrailerListUseCase(
    private val repository: TrailerRepository
) {
    suspend operator fun invoke(movieId : Int) : List<Trailer> =
        repository.getTrailerList(movieId)
}