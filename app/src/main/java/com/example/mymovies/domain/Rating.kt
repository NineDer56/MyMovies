package com.example.mymovies.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Rating(
    @SerializedName("kp") val kpRating: Double,
    @SerializedName("imdb") val imdbRating : Double
) : Serializable