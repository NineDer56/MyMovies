package com.example.mymovies.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repository.MovieItemRepositoryImpl
import com.example.mymovies.data.repository.ReviewRepositoryImpl
import com.example.mymovies.data.repository.TrailerRepositoryImpl
import com.example.mymovies.domain.usecase.AddFavouriteMovieUseCase
import com.example.mymovies.domain.usecase.GetFavouriteMovieItemUseCase
import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.dto.review.Review
import com.example.mymovies.domain.dto.trailer.Trailer
import com.example.mymovies.domain.usecase.GetReviewListUseCase
import com.example.mymovies.domain.usecase.GetTrailerListUseCase
import com.example.mymovies.domain.usecase.RemoveFavouriteMovieItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private var _movie = MutableLiveData<MovieItem?>()
    val movie : LiveData<MovieItem?>
        get() = _movie

    private var _trailers = MutableLiveData<List<Trailer>>()
    val trailers : LiveData<List<Trailer>>
        get() = _trailers

    private var _reviews = MutableLiveData<List<Review>>()
    val reviews : LiveData<List<Review>>
        get() = _reviews

    private val movieRepository = MovieItemRepositoryImpl(application)
    private val trailerRepository = TrailerRepositoryImpl(application)
    private val reviewRepository = ReviewRepositoryImpl(application)

    private val getFavouriteMovieItemUseCase = GetFavouriteMovieItemUseCase(movieRepository)
    private val addFavouriteMovieItemUseCase = AddFavouriteMovieUseCase(movieRepository)
    private val removeFavouriteMovieItemUseCase = RemoveFavouriteMovieItemUseCase(movieRepository)
    private val getTrailerListUseCase = GetTrailerListUseCase(trailerRepository)
    private val getReviewListUseCase = GetReviewListUseCase(reviewRepository)

    //TODO вынести в инит блок
    fun loadMovie(movieId: Int){
        viewModelScope.launch(Dispatchers.IO){
            val movieFromDb = getFavouriteMovieItemUseCase(movieId)
            withContext(Dispatchers.Main){
                _movie.value = movieFromDb
            }
        }
    }

    fun addMovie(movie: MovieItem){
        viewModelScope.launch{
            addFavouriteMovieItemUseCase(movie)
            loadMovie(movie.id)
        }
    }

    fun removeMovie(movie : MovieItem){
        viewModelScope.launch {
            removeFavouriteMovieItemUseCase(movie)
            loadMovie(movie.id)
        }
    }

    fun loadTrailers(movieId: Int){
        viewModelScope.launch {
            try {
                val trailers = getTrailerListUseCase(movieId)
                _trailers.value = trailers
            } catch (e: Exception){
                Log.d(TAG, e.message ?: "loadTrailers failed")
            }
        }
    }

    fun loadReviews(movieId: Int){
        viewModelScope.launch {
            try {
                val reviews = getReviewListUseCase(movieId)
                _reviews.value = reviews
            } catch (e: Exception) {
                Log.d(TAG, e.message ?: "loadReviews failed")
            }
        }
    }


    companion object{
        private const val TAG = "MovieDetailViewModel"
    }
}