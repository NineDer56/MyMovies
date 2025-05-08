package com.example.mymovies.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.mymovies.data.retrofit.MovieApiFactory
import com.example.mymovies.data.room.MovieItemDatabase
import com.example.mymovies.data.room.MovieItemMapper
import com.example.mymovies.domain.MovieItem
import com.example.mymovies.domain.MovieItemRepository
import java.lang.Appendable

class MovieItemRepositoryImpl(
    private val application: Application
) : MovieItemRepository {

    private val dao = MovieItemDatabase.getInstance(application).movieDao()
    private val mapper = MovieItemMapper()

    override suspend fun getMovieItemList(page: Int): List<MovieItem> {
        return MovieApiFactory.movieApiService.loadMovies(page).movies
    }

    override suspend fun getFavouriteMovieItemList(): List<MovieItem> {
        return dao.getAllFavouriteMovies().map { mapper.dbModelToMovieItem(it) }
    }

    override suspend fun getFavouriteMovieItem(movieId : Int): MovieItem? {
        val movieFromDb = dao.getFavouriteMovie(movieId) ?: return null
        return mapper.dbModelToMovieItem(movieFromDb)
    }

    override suspend fun addFavouriteMovie(movieItem: MovieItem) {
        dao.addMovie(mapper.movieItemToDbModel(movieItem))
    }

    override suspend fun removeFavouriteMovie(movieItem: MovieItem) {
        dao.removeMovie(mapper.movieItemToDbModel(movieItem))
    }
}