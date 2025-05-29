package com.example.mymovies.data.retrofit

import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.dto.movie.Poster
import com.example.mymovies.domain.dto.movie.Rating
import com.example.mymovies.domain.dto.review.Review
import com.example.mymovies.domain.dto.trailer.Trailer

object MovieNwMapper {
    fun nwModelToMovieItem(nwModel: MovieItemNwModel): MovieItem {
        return MovieItem(
            id = nwModel.id,
            name = nwModel.name,
            type = nwModel.type,
            year = nwModel.year,
            description = nwModel.description,
            rating = nwModelToRating(nwModel.rating),
            poster = nwModelToPoster(nwModel.poster)
        )
    }

    fun movieItemToNwModel(movieItem: MovieItem) : MovieItemNwModel {
        return MovieItemNwModel(
            id = movieItem.id,
            name = movieItem.name,
            type = movieItem.type,
            year = movieItem.year,
            description = movieItem.description,
            rating =  ratingToNwModel(movieItem.rating),
            poster = posterToNwModel(movieItem.poster)
        )
    }

    fun nwModelToReview(nwModel : ReviewNwModel) : Review{
        return Review(
            author = nwModel.author,
            title = nwModel.title,
            type = nwModel.type,
            review = nwModel.review,
            reviewLikes = nwModel.reviewLikes,
            reviewDislikes = nwModel.reviewDislikes,
            updatedAt = nwModel.updatedAt
        )
    }

    fun reviewToNwModel(review: Review) : ReviewNwModel{
        return ReviewNwModel(
            author = review.author,
            title = review.title,
            type = review.type,
            review = review.review,
            reviewLikes = review.reviewLikes,
            reviewDislikes = review.reviewDislikes,
            updatedAt = review.updatedAt
        )
    }

    fun nwModelToTrailer(nwModel : TrailerNwModel) : Trailer {
        return Trailer(
            name = nwModel.name,
            url = nwModel.url
        )
    }

    fun trailerToNwModel(trailer: Trailer) : TrailerNwModel {
        return TrailerNwModel(
            name = trailer.name,
            url = trailer.url
        )
    }

    fun nwModelToPoster(nwModel: PosterNwModel) : Poster{
        return Poster(
            url = nwModel.url
        )
    }

    fun posterToNwModel(poster: Poster) : PosterNwModel{
        return PosterNwModel(
            url = poster.url
        )
    }

    fun nwModelToRating(nwModel: RatingNwModel) : Rating{
        return Rating(
            kpRating = nwModel.kpRating,
            imdbRating = nwModel.imdbRating
        )
    }

    fun ratingToNwModel(rating: Rating) : RatingNwModel{
        return RatingNwModel(
            kpRating = rating.kpRating,
            imdbRating = rating.imdbRating
        )
    }
}