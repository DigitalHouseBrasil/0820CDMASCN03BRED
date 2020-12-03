package com.github.cesar1287.desafiopicpayandroid.tmdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.github.cesar1287.desafiopicpayandroid.databinding.ActivityMovieDetailBinding
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel.MovieDetailViewModel
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.MovieDetail.KEY_INTENT_MOVIE_ID

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var viewModel: MovieDetailViewModel
    private var movie: Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        val movieId = intent.getIntExtra(KEY_INTENT_MOVIE_ID, -1)

        viewModel.getMovieById(movieId)

        setupObservables()
    }

    private fun setupObservables() {
        viewModel.onMovieDetailLoaded.observe(this, {
            movie = it
            binding.apply {
                tvMovieDetailTitle.text = it?.title
                tvMovieDetailDescription.text = it?.overview
                Glide
                    .with(this@MovieDetailActivity)
                    .load(it?.posterPath)
                    .into(ivMovieDetailPoster)
            }
        })

        binding.btMovieDetailDelete.setOnClickListener {
            movie?.let {
                viewModel.updateMovie(it)
            }
            finish()
        }
    }
}