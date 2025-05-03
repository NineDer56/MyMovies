package com.example.mymovies.domain

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("kp") val kpRating: Double,
    @SerializedName("imdb") val imdbRating : Double
)