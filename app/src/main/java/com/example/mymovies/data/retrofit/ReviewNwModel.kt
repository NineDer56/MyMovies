package com.example.mymovies.data.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ReviewNwModel(
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