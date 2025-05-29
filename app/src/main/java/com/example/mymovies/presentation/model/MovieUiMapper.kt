package com.example.mymovies.presentation.model

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.dto.movie.Poster
import com.example.mymovies.domain.dto.movie.Rating

object MovieUiMapper {
    fun uiModelToMovieItem(uiModel: MovieItemUiModel): MovieItem {
        return MovieItem(
            id = uiModel.id,
            name = uiModel.name,
            type = uiModel.type,
            year = uiModel.year,
            description = uiModel.description,
            rating = uiModelToRating(uiModel.rating),
            poster = uiModelToPoster(uiModel.poster)
        )
    }

    fun movieItemToUiModel(movieItem: MovieItem) : MovieItemUiModel {
        return MovieItemUiModel(
            id = movieItem.id,
            name = movieItem.name,
            type = movieItem.type,
            year = movieItem.year,
            description = movieItem.description,
            rating =  ratingToUiModel(movieItem.rating),
            poster = posterToUiModel(movieItem.poster)
        )
    }


    fun uiModelToPoster(uiModel: PosterUiModel) : Poster {
        return Poster(
            url = uiModel.url
        )
    }

    fun posterToUiModel(poster: Poster) : PosterUiModel {
        return PosterUiModel(
            url = poster.url
        )
    }

    fun uiModelToRating(uiModel: RatingUiModel) : Rating {
        return Rating(
            kpRating = uiModel.kpRating,
            imdbRating = uiModel.imdbRating
        )
    }

    fun ratingToUiModel(rating: Rating) : RatingUiModel {
        return RatingUiModel(
            kpRating = rating.kpRating,
            imdbRating = rating.imdbRating
        )
    }
}