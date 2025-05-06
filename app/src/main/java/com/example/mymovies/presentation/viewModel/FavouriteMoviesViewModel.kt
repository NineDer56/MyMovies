package com.example.mymovies.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.MovieItemRepositoryImpl
import com.example.mymovies.domain.GetFavouriteMovieItemListUseCase
import com.example.mymovies.domain.MovieItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteMoviesViewModel(
    application: Application
) : AndroidViewModel(application) {

    private var _movies = MutableLiveData<List<MovieItem>>()
    val movies: LiveData<List<MovieItem>>
        get() = _movies

    private val repository = MovieItemRepositoryImpl(application)
    private val getFavouriteMovieItemListUseCase = GetFavouriteMovieItemListUseCase(repository)

    fun loadMoviesFromDb() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movies = getFavouriteMovieItemListUseCase.getFavouriteMovieItemList()
                _movies.value = movies
            } catch (e: Exception) {
                e.message?.let { Log.d(TAG, it) }
            }
        }
    }

    companion object {
        private const val TAG = "FavouriteMoviesViewModel"
    }
}