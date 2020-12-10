package com.github.cesar1287.desafiopicpayandroid.tmdb.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.github.cesar1287.desafiopicpayandroid.databinding.ActivityTmdbHomeBinding
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel.TmdbHomeViewModel
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.MovieDetail.KEY_INTENT_MOVIE_ID

class TmdbHomeActivity : AppCompatActivity() {

    private lateinit var viewModel: TmdbHomeViewModel
    private lateinit var binding: ActivityTmdbHomeBinding

    private val tmdbHomeAdapter : TmdbHomeAdapter by lazy {
        TmdbHomeAdapter { movieId ->
            val intent = Intent(this@TmdbHomeActivity, MovieDetailActivity::class.java)
            intent.putExtra(KEY_INTENT_MOVIE_ID, movieId)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmdbHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TmdbHomeViewModel::class.java)

        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadContent()
    }

    private fun loadContent() {
        viewModel.moviePagedList?.observe(this, {
            tmdbHomeAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        binding.rvTmdbHome.apply {
            layoutManager = GridLayoutManager(this@TmdbHomeActivity, 2)
            adapter = tmdbHomeAdapter
        }
    }
}