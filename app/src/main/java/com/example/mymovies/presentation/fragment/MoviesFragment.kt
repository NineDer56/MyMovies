package com.example.mymovies.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentMoviesBinding
import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.presentation.adapter.MovieListAdapter
import com.example.mymovies.presentation.viewModel.MovieListViewModel

class MoviesFragment : Fragment() {

    private var _binding : FragmentMoviesBinding? = null
    val binding : FragmentMoviesBinding
        get() = _binding ?: throw RuntimeException("FragmentMoviesBinding is null")

    private val navController by lazy {
        findNavController()
    }

    private val viewModel : MovieListViewModel by lazy {
        ViewModelProvider(this)[MovieListViewModel::class.java]
    }

    private val adapter : MovieListAdapter by lazy {
        MovieListAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenu()
        initRecyclerView(view.context)
        observeLiveData()
        Log.d(TAG, "onViewCreated")
    }

    private fun initMenu(){
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId){
                    R.id.itemFavourite ->{
                        navController.navigate(R.id.action_moviesFragment_to_favouriteMoviesFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun initRecyclerView(context: Context){
        with(binding){
            rvMovies.layoutManager = GridLayoutManager(context, 2)
            rvMovies.adapter = adapter
            adapter.onReachEndListener = object : MovieListAdapter.OnReachEndListener{
                override fun onReachEnd() {
                    viewModel.loadMovies()
                    Log.d(TAG, "onReachEnd")
                }
            }

            adapter.onMovieClickListener = object : MovieListAdapter.OnMovieClickListener{
                override fun onMovieClick(movie: MovieItem) {
                    navController.navigate(
                        MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(movie)
                    )
                }
            }
        }
    }

    private fun observeLiveData(){
        with(viewModel){
            movies.observe(viewLifecycleOwner){
                adapter.submitList(it)
            }

            isLoading.observe(viewLifecycleOwner){
                if(it){
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val TAG = "MoviesFragment"
    }
}