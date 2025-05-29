package com.example.mymovies.data.repository

import android.app.Application
import com.example.mymovies.data.retrofit.MovieApiFactory
import com.example.mymovies.data.retrofit.MovieNwMapper
import com.example.mymovies.data.room.MovieItemDatabase
import com.example.mymovies.data.room.MovieDbMapper
import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.dto.review.Review
import com.example.mymovies.domain.repository.MovieItemRepository
import com.example.mymovies.domain.dto.trailer.Trailer

class MovieItemRepositoryImpl(
    private val application: Application
) : MovieItemRepository {

    private val dao = MovieItemDatabase.getInstance(application).movieDao()
    private val dbMapper = MovieDbMapper
    private val nwMapper = MovieNwMapper

    override suspend fun getMovieItemList(page: Int): List<MovieItem> {
        return MovieApiFactory.movieApiService.loadMovies(page).movies
            .map { nwMapper.nwModelToMovieItem(it) }
    }

    override suspend fun getFavouriteMovieItemList(): List<MovieItem> {
        return dao.getAllFavouriteMovies().map { dbMapper.dbModelToMovieItem(it) }
    }

    override suspend fun getFavouriteMovieItem(movieId: Int): MovieItem? {
        val movieFromDb = dao.getFavouriteMovie(movieId) ?: return null
        return dbMapper.dbModelToMovieItem(movieFromDb)
    }

    override suspend fun addFavouriteMovie(movieItem: MovieItem) {
        dao.addMovie(dbMapper.movieItemToDbModel(movieItem))
    }

    override suspend fun removeFavouriteMovie(movieItem: MovieItem) {
        dao.removeMovie(dbMapper.movieItemToDbModel(movieItem))
    }
}