package com.example.mymovies.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repository.MovieItemRepositoryImpl
import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.usecase.GetFavouriteMovieItemListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavouriteMoviesViewModel(
    application: Application
) : AndroidViewModel(application) {

    private var _movies = MutableLiveData<List<MovieItem>>()
    val movies: LiveData<List<MovieItem>>
        get() = _movies

    private val repository = MovieItemRepositoryImpl(application)
    private val getFavouriteMovieItemListUseCase = GetFavouriteMovieItemListUseCase(repository)

    fun loadMoviesFromDb() {
        viewModelScope.launch {
            val movies = withContext(Dispatchers.IO){
                getFavouriteMovieItemListUseCase.getFavouriteMovieItemList()
            }
            _movies.value = movies
        }
    }

    companion object {
        private const val TAG = "FavouriteMoviesViewModel"
    }
}