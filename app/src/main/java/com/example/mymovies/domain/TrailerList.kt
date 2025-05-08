package com.example.mymovies.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TrailerList(
    @SerializedName("trailers")
    val trailers : List<Trailer>
) : Serializable