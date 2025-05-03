package com.example.mymovies.data

import com.example.mymovies.domain.MovieItem
import com.example.mymovies.domain.MovieItemRepository

class MovieItemRepositoryImpl : MovieItemRepository {

    override suspend fun getMovieItemList(page: Int): List<MovieItem> {
        return MovieApiFactory.movieApiService.loadMovies(page).movies
    }
}