package com.example.mymovies.domain.dto.review

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Review(
    @SerializedName("author")
    val author : String,
    @SerializedName("title")
    val title : String,
    @SerializedName("type")
    val type : String,
    @SerializedName("review")
    val review: String,
    @SerializedName("reviewLikes")
    val reviewLikes : Int,
    @SerializedName("reviewDislikes")
    val reviewDislikes : Int,
    @SerializedName("updatedAt")
    val updatedAt : String
) : Serializable