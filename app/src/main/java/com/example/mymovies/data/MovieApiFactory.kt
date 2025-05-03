package com.example.mymovies.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiFactory {
    companion object{
        private const val BASE_URL : String = "https://api.kinopoisk.dev/v1.4/"

        private val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieApiService : MovieApiService = retrofit.create(MovieApiService::class.java)
    }
}