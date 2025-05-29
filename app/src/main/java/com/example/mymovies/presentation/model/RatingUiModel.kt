package com.example.mymovies.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingUiModel(
    val kpRating: Double,
    val imdbRating : Double
) : Parcelable