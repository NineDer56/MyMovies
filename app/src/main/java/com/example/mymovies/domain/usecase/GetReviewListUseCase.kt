package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.review.Review
import com.example.mymovies.domain.repository.MovieItemRepository

class GetReviewListUseCase(
    private val repository: MovieItemRepository
) {
    suspend fun getReviewList(movieId: Int) : List<Review>{
        return repository.getReviewList(movieId)
    }
}