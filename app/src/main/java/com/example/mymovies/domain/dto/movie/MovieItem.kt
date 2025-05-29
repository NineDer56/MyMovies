package com.example.mymovies.domain.dto.movie

data class MovieItem (
    val id : Int,
    val name : String,
    val type : String,
    val year : Int,
    val description : String,
    val rating : Rating,
    val poster : Poster
)
