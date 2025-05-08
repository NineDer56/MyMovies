package com.example.mymovies.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieItemDao {

    @Query("SELECT * FROM movies")
    fun getAllFavouriteMovies() : List<MovieItemDbModel>

    @Query("SELECT * FROM movies WHERE id=:movieId")
    fun getFavouriteMovie(movieId: Int) : MovieItemDbModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movie : MovieItemDbModel)

    @Delete
    suspend fun removeMovie(movie : MovieItemDbModel)
}