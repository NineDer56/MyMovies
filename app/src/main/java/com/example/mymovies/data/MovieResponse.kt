package com.example.mymovies.data

import com.example.mymovies.data.retrofit.MovieItemNwModel
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("docs")
    val movies : List<MovieItemNwModel>
)
