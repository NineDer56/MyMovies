package com.example.mymovies.domain.dto.review

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ReviewResponse(
    @SerializedName("docs")
    val reviews : List<Review>
) : Serializable
