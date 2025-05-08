package com.example.mymovies.data.retrofit

import com.example.mymovies.domain.dto.movie.MovieResponse
import com.example.mymovies.domain.dto.trailer.TrailerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie?token=ZWHFZS9-0EEMCJ5-HSVV3NX-7G8H6SJ&sortField=votes.kp&sortType=-1&limit=30")
    suspend fun loadMovies(@Query("page") page : Int) : MovieResponse

    @GET("movie/{id}?token=ZWHFZS9-0EEMCJ5-HSVV3NX-7G8H6SJ")
    suspend fun loadTrailers(@Path("id") movieId : Int) : TrailerResponse
}