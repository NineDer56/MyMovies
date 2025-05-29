package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.dto.review.Review
import com.example.mymovies.domain.repository.MovieItemRepository
import com.example.mymovies.domain.repository.ReviewRepository

class GetReviewListUseCase(
    private val repository: ReviewRepository
) {
    suspend operator fun invoke(movieId: Int) : List<Review> =
        repository.getReviewList(movieId)
}