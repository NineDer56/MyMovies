package com.example.mymovies.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PosterUiModel(
    val url : String
) : Parcelable