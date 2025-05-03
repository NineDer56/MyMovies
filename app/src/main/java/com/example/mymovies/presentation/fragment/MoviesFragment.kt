package com.example.mymovies.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mymovies.databinding.FragmentMoviesBinding
import com.example.mymovies.presentation.adapter.MovieListAdapter
import com.example.mymovies.presentation.viewModel.MovieListViewModel

class MoviesFragment : Fragment() {

    private var _binding : FragmentMoviesBinding? = null
    val binding : FragmentMoviesBinding
        get() = _binding ?: throw RuntimeException("FragmentMoviesBinding is null")

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
        initRecyclerView(view.context)
        observeLiveData()
        viewModel.loadMovies()

    }

    private fun initRecyclerView(context: Context){
        with(binding){
            rvMovies.layoutManager = GridLayoutManager(context, 2)
            rvMovies.adapter = adapter
        }
    }

    private fun observeLiveData(){
        with(viewModel){
            movies.observe(viewLifecycleOwner){
                adapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}