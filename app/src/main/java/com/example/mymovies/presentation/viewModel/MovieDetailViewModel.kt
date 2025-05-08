package com.example.mymovies.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.MovieItemRepositoryImpl
import com.example.mymovies.domain.usecase.AddFavouriteMovieUseCase
import com.example.mymovies.domain.usecase.GetFavouriteMovieItemUseCase
import com.example.mymovies.domain.MovieItem
import com.example.mymovies.domain.usecase.RemoveFavouriteMovieItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private var _movie = MutableLiveData<MovieItem?>()
    val movie : LiveData<MovieItem?>
        get() = _movie

    private val repository = MovieItemRepositoryImpl(application)
    private val getFavouriteMovieItemUseCase = GetFavouriteMovieItemUseCase(repository)
    private val addFavouriteMovieItemUseCase = AddFavouriteMovieUseCase(repository)
    private val removeFavouriteMovieItemUseCase = RemoveFavouriteMovieItemUseCase(repository)

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
}