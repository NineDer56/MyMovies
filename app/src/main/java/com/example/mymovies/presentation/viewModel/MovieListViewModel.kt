package com.example.mymovies.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repository.MovieItemRepositoryImpl
import com.example.mymovies.domain.usecase.GetMovieItemListUseCase
import com.example.mymovies.domain.dto.movie.MovieItem
import kotlinx.coroutines.launch

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    private var page = 1
    private val repository = MovieItemRepositoryImpl(application)
    private val getMovieItemListUseCase = GetMovieItemListUseCase(repository)

    private val _movies = MutableLiveData<List<MovieItem>>()
    val movies : LiveData<List<MovieItem>>
        get() = _movies

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading : LiveData<Boolean>
        get() = _isLoading

    init{
        loadMovies()
    }

    fun loadMovies(){
        if(isLoading.value == true){
            return
        }
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val movieList = _movies.value?.toMutableList()
                val res  = getMovieItemListUseCase(page)
                if(movieList != null){
                    movieList.addAll(res)
                    _movies.value = movieList
                } else {
                    _movies.value = res
                }
                Log.d(TAG, "page: $page")
                page++
                _isLoading.value = false
            } catch (e: Exception){
                Log.d(TAG, e.toString())
            }
        }

    }

    companion object{
        private const val TAG = "MovieListViewModel"
    }

}