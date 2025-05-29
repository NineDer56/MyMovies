package com.example.mymovies.data.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RatingNwModel(
    @SerializedName("kp") val kpRating: Double,
    @SerializedName("imdb") val imdbRating : Double
) : Serializable
