package com.example.mymovies.domain.repository

import com.example.mymovies.domain.dto.trailer.Trailer

interface TrailerRepository {
    suspend fun getTrailerList(movieId: Int) : List<Trailer>
}