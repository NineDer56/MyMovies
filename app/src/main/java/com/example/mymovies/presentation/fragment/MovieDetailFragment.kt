package com.example.mymovies.presentation.fragment

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mymovies.databinding.FragmentMovieDetailBinding
import com.example.mymovies.domain.dto.movie.MovieItem
import com.example.mymovies.domain.dto.trailer.Trailer
import com.example.mymovies.presentation.adapter.ReviewListAdapter
import com.example.mymovies.presentation.adapter.TrailerListAdapter
import com.example.mymovies.presentation.viewModel.MovieDetailViewModel


class MovieDetailFragment : Fragment() {

    // TODO Добавить: трейлеры, отзывы, проверить эффективность работы с избранными передалть MovieItem


    private var _binding : FragmentMovieDetailBinding? = null
    val binding : FragmentMovieDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentMovieDetailBinding is null")

    private val args : MovieDetailFragmentArgs by navArgs()

    private val viewModel : MovieDetailViewModel by lazy {
        ViewModelProvider(this)[MovieDetailViewModel::class.java]
    }

    private val trailerAdapter : TrailerListAdapter by lazy {
        TrailerListAdapter()
    }

    private val reviewAdapter : ReviewListAdapter by lazy {
        ReviewListAdapter()
    }

    private lateinit var starOn : Drawable
    private lateinit var starOff : Drawable

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

        initStars(view)
        initTrailerRecyclerView(view)
        initReviewRecyclerView(view)
        observeViewModel(movie)
        viewModel.loadMovie(movie.id)
        viewModel.loadTrailers(movie.id)
        viewModel.loadReviews(movie.id)
    }

    private fun observeViewModel(movie: MovieItem){
        viewModel.movie.observe(viewLifecycleOwner){movieFromDb ->
           if(movieFromDb != null){
               binding.ivStar.setImageDrawable(starOn)
               binding.ivStar.setOnClickListener{
                   viewModel.removeMovie(movie)
               }
           } else {
               binding.ivStar.setImageDrawable(starOff)
               binding.ivStar.setOnClickListener{
                   viewModel.addMovie(movie)
               }
           }
        }

        viewModel.trailers.observe(viewLifecycleOwner){trailers ->
            trailerAdapter.setTrailers(trailers)
        }

        viewModel.reviews.observe(viewLifecycleOwner){reviews ->
            reviewAdapter.setReviews(reviews)
        }
    }

    private fun initTrailerRecyclerView(view : View){
        with(binding.rvTrailers){
            layoutManager = LinearLayoutManager(view.context)
            adapter = this@MovieDetailFragment.trailerAdapter
        }

        trailerAdapter.onPlayClickListener = object : TrailerListAdapter.OnPlayClickListener{
            override fun onPlayClick(trailer: Trailer) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(trailer.url))
                startActivity(intent)
            }
        }
    }

    private fun initReviewRecyclerView(view : View){
        with(binding.rvReviews){
            layoutManager = LinearLayoutManager(view.context)
            adapter = reviewAdapter
        }
    }

    private fun initStars(view : View){
        starOn = ContextCompat.getDrawable(
            view.context,
            android.R.drawable.star_big_on
        ) ?: throw RuntimeException("drawable starOn is null")

        starOff = ContextCompat.getDrawable(
            view.context,
            android.R.drawable.star_big_off
        ) ?: throw RuntimeException("drawable starOff is null")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}