package com.example.mymovies.data.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PosterNwModel(
    @SerializedName("url") val url : String
) : Serializable