package com.example.mymovies.data.repository

import android.app.Application
import com.example.mymovies.data.retrofit.MovieApiFactory
import com.example.mymovies.data.retrofit.MovieNwMapper
import com.example.mymovies.domain.dto.review.Review
import com.example.mymovies.domain.repository.ReviewRepository

class ReviewRepositoryImpl (
    private val application: Application
) : ReviewRepository {

    private val nwMapper = MovieNwMapper

    override suspend fun getReviewList(movieId: Int): List<Review> {
        return MovieApiFactory.movieApiService.loadReviews(movieId).reviews
            .map { nwMapper.nwModelToReview(it) }
    }
}
