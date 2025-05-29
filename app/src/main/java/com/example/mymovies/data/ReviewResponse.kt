package com.example.mymovies.data

import com.example.mymovies.data.retrofit.ReviewNwModel
import com.example.mymovies.domain.dto.review.Review
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ReviewResponse(
    @SerializedName("docs")
    val reviews : List<ReviewNwModel>
) : Serializable
