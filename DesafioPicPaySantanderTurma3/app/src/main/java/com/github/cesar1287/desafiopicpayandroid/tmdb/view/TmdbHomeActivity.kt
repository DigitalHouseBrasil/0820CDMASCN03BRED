package com.github.cesar1287.desafiopicpayandroid.tmdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.github.cesar1287.desafiopicpayandroid.databinding.ActivityTmdbHomeBinding
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel.TmdbHomeViewModel

class TmdbHomeActivity : AppCompatActivity() {

    private lateinit var viewModel: TmdbHomeViewModel
    private lateinit var binding: ActivityTmdbHomeBinding
    private val tmdbHomeAdapter : TmdbHomeAdapter by lazy {
        TmdbHomeAdapter {
            val movieClicked = it
            //chamar outra activity ou fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmdbHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadContent()
    }

    private fun loadContent() {
        viewModel = ViewModelProvider(this).get(TmdbHomeViewModel::class.java)
        viewModel.moviePagedList?.observe(this, { pagedList ->
            tmdbHomeAdapter.submitList(pagedList)
        })
    }

    private fun setupRecyclerView() {
        binding.rvTmdbHome.apply {
            layoutManager = GridLayoutManager(this@TmdbHomeActivity, 2)
            adapter = tmdbHomeAdapter
        }
    }
}