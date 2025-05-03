package com.example.mymovies.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private var _binding : FragmentMoviesBinding? = null
    val binding : FragmentMoviesBinding
        get() = _binding ?: throw RuntimeException("FragmentMoviesBinding is null")


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
    }

    private fun initRecyclerView(context: Context){
        with(binding){
            rvMovies.layoutManager = GridLayoutManager(context, 2)
            rvMovies.adapter = MovieListAdapter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}