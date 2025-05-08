package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.review.Review
import com.example.mymovies.domain.repository.MovieItemRepository

class GetReviewListUseCase(
    private val repository: MovieItemRepository
) {
    suspend operator fun invoke(movieId: Int) : List<Review> =
        repository.getReviewList(movieId)
}