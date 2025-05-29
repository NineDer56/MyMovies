package com.example.mymovies.domain.dto.review

data class Review(
    val author : String,
    val title : String,
    val type : String,
    val review: String,
    val reviewLikes : Int,
    val reviewDislikes : Int,
    val updatedAt : String
)