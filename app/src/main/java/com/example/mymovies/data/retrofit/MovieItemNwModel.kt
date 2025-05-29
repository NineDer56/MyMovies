package com.example.mymovies.data.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieItemNwModel (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("type") val type : String,
    @SerializedName("year") val year : Int,
    @SerializedName("description") val description : String,
    @SerializedName("rating") val rating : RatingNwModel,
    @SerializedName("poster") val poster : PosterNwModel
) : Serializable
