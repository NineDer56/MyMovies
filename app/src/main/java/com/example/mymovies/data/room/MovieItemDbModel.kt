package com.example.mymovies.data.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mymovies.domain.dto.movie.Poster
import com.example.mymovies.domain.dto.movie.Rating
import java.io.Serializable

@Entity(tableName = "movies")
data class MovieItemDbModel (
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    val name : String,
    val type : String,
    val year : Int,
    val description : String,
    @Embedded val rating : Rating,
    @Embedded val poster : Poster
) : Serializable