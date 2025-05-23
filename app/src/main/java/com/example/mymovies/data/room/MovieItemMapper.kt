package com.example.mymovies.data.room

import com.example.mymovies.domain.dto.movie.MovieItem

class MovieItemMapper {
    fun dbModelToMovieItem(dbModel: MovieItemDbModel): MovieItem {
        return MovieItem(
            id = dbModel.id,
            name = dbModel.name,
            type = dbModel.type,
            year = dbModel.year,
            description = dbModel.description,
            rating = dbModel.rating,
            poster = dbModel.poster
        )
    }

//    fun dbModelToMovieItemNullable(dbModel: MovieItemDbModel?): MovieItem? {
//        if(dbModel == null)
//            return null
//        return MovieItem(
//            id = dbModel.id,
//            name = dbModel.name,
//            type = dbModel.type,
//            year = dbModel.year,
//            description = dbModel.description,
//            rating = dbModel.rating,
//            poster = dbModel.poster
//        )
//    }

    fun movieItemToDbModel(movieItem: MovieItem) : MovieItemDbModel{
        return MovieItemDbModel(
            id = movieItem.id,
            name = movieItem.name,
            type = movieItem.type,
            year = movieItem.year,
            description = movieItem.description,
            rating = movieItem.rating,
            poster = movieItem.poster
        )
    }

    fun dbModelListToMovieItemList(movies : List<MovieItemDbModel>) : List<MovieItem>{
        return movies.map { dbModelToMovieItem(it) }
    }
}