package com.example.mymovies.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItemUiModel (
    val id : Int,
    val name : String,
    val type : String,
    val year : Int,
    val description : String,
    val rating : RatingUiModel,
    val poster : PosterUiModel
) : Parcelable