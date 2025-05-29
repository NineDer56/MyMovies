package com.example.mymovies.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mymovies.databinding.FragmentFavouriteMoviesBinding
import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.presentation.adapter.MovieListAdapter
import com.example.mymovies.presentation.model.MovieUiMapper
import com.example.mymovies.presentation.viewModel.FavouriteMoviesViewModel

class FavouriteMoviesFragment : Fragment() {

    private var _binding: FragmentFavouriteMoviesBinding? = null
    val binding: FragmentFavouriteMoviesBinding
        get() = _binding ?: throw RuntimeException("FragmentFavouriteMoviesBinding is null")

    private val adapter: MovieListAdapter by lazy {
        MovieListAdapter()
    }

    private val viewModel: FavouriteMoviesViewModel by lazy {
        ViewModelProvider(this)[FavouriteMoviesViewModel::class.java]
    }

    private val navController by lazy {
        findNavController()
    }

    private val mapper = MovieUiMapper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view.context)
        observeLiveData()
        viewModel.loadMoviesFromDb()
    }

    private fun observeLiveData() {
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initRecyclerView(context: Context) {
        with(binding.rvFavouriteMovies) {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@FavouriteMoviesFragment.adapter
            // из-за одинаковых названий adapter
            // в строке adapter = adapter были 2 одинаковых объекта
            // вместо (MovieListAdapter() был rv.adapter)
            // и в итоге rv.adapter прсиваивался null
        }

        adapter.onMovieClickListener = object : MovieListAdapter.OnMovieClickListener{
            override fun onMovieClick(movie: MovieItem) {
                navController.navigate(
                    FavouriteMoviesFragmentDirections.actionFavouriteMoviesFragmentToMovieDetailFragment(mapper.movieItemToUiModel(movie))
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}