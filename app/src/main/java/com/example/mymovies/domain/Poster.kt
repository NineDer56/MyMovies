package com.example.mymovies.domain

import com.google.gson.annotations.SerializedName

data class Poster(
    @SerializedName("url") val url : String
)