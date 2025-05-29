package com.example.mymovies.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TrailerResponse(
    @SerializedName("videos")
    val trailerResponse : TrailerList
) : Serializable