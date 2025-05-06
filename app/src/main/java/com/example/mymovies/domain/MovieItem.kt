package com.example.mymovies.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MovieItem (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("type") val type : String,
    @SerializedName("year") val year : Int,
    @SerializedName("description") val description : String,
    @SerializedName("rating") val rating : Rating,
    @SerializedName("poster") val poster : Poster
) : Serializable // TODO убрать