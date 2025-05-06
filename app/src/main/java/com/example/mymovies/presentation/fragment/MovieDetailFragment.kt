package com.example.mymovies.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentMovieDetailBinding
import com.example.mymovies.databinding.FragmentMoviesBinding


class MovieDetailFragment : Fragment() {

    private var _binding : FragmentMovieDetailBinding? = null
    val binding : FragmentMovieDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentMovieDetailBinding is null")

    private val args : MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = args.movie

        with(binding){
            Glide.with(view.context)
                .load(movie.poster.url)
                .into(ivPoster)
            tvTitle.text = movie.name
            tvYear.text = movie.year.toString()
            tvDescription.text = movie.description
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}