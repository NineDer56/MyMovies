package com.example.mymovies.data

import com.example.mymovies.domain.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie?token=ZWHFZS9-0EEMCJ5-HSVV3NX-7G8H6SJ&sortField=votes.kp&sortType=-1&limit=30")
    suspend fun loadMovies(@Query("page") page : Int) : MovieResponse
}