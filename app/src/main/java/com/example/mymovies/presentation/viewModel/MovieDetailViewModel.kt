package com.example.mymovies.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repository.MovieItemRepositoryImpl
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

    private val repository = MovieItemRepositoryImpl(application)
    private val getFavouriteMovieItemUseCase = GetFavouriteMovieItemUseCase(repository)
    private val addFavouriteMovieItemUseCase = AddFavouriteMovieUseCase(repository)
    private val removeFavouriteMovieItemUseCase = RemoveFavouriteMovieItemUseCase(repository)
    private val getTrailerListUseCase = GetTrailerListUseCase(repository)
    private val getReviewListUseCase = GetReviewListUseCase(repository)

    //TODO вынести в инит блок
    fun loadMovie(movieId: Int){
        viewModelScope.launch(Dispatchers.IO){
            val movieFromDb = getFavouriteMovieItemUseCase.getFavouriteMovieItem(movieId)
            withContext(Dispatchers.Main){
                _movie.value = movieFromDb
            }
        }
    }

    fun addMovie(movie: MovieItem){
        viewModelScope.launch{
            addFavouriteMovieItemUseCase.addFavouriteMovie(movie)
            loadMovie(movie.id)
        }
    }

    fun removeMovie(movie : MovieItem){
        viewModelScope.launch {
            removeFavouriteMovieItemUseCase.removeFavouriteMovieItem(movie)
            loadMovie(movie.id)
        }
    }

    fun loadTrailers(movieId: Int){
        viewModelScope.launch {
            try {
                val trailers = getTrailerListUseCase.getTrailerList(movieId)
                _trailers.value = trailers
            } catch (e: Exception){
                Log.d(TAG, e.message ?: "loadTrailers failed")
            }
        }
    }

    fun loadReviews(movieId: Int){
        viewModelScope.launch {
            try {
                val reviews = getReviewListUseCase.getReviewList(movieId)
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