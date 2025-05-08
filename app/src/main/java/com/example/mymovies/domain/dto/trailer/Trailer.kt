package com.example.mymovies.domain.dto.trailer

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Trailer(
    @SerializedName("name")
    val name : String,

    @SerializedName("url")
    val url : String
) : Serializable