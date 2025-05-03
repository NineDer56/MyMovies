package com.example.mymovies.domain

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("docs")
    val movies : List<MovieItem>
)
