package com.example.mymovies.data.repository

import android.app.Application
import com.example.mymovies.data.retrofit.MovieApiFactory
import com.example.mymovies.data.retrofit.MovieNwMapper
import com.example.mymovies.domain.dto.trailer.Trailer
import com.example.mymovies.domain.repository.TrailerRepository

class TrailerRepositoryImpl(
    val application: Application
) : TrailerRepository{

    private val nwMapper = MovieNwMapper

    override suspend fun getTrailerList(movieId: Int): List<Trailer> {
        return MovieApiFactory.movieApiService.loadTrailers(movieId).trailerResponse.trailers
            .map { nwMapper.nwModelToTrailer(it) }
    }
}