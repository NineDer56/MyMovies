package com.example.mymovies.data

import com.example.mymovies.data.retrofit.TrailerNwModel
import com.example.mymovies.domain.dto.trailer.Trailer
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TrailerList(
    @SerializedName("trailers")
    val trailers : List<TrailerNwModel>
) : Serializable