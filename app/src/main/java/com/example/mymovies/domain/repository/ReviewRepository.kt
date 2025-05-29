package com.example.mymovies.domain.repository

import com.example.mymovies.domain.dto.review.Review

interface ReviewRepository {
    suspend fun getReviewList(movieId: Int) : List<Review>
}