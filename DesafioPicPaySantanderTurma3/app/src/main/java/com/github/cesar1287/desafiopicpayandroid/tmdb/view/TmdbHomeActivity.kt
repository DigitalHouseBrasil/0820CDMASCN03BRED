package com.github.cesar1287.desafiopicpayandroid.tmdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.github.cesar1287.desafiopicpayandroid.databinding.ActivityTmdbHomeBinding
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel.TmdbHomeViewModel

class TmdbHomeActivity : AppCompatActivity() {

    private lateinit var viewModel: TmdbHomeViewModel
    private lateinit var binding: ActivityTmdbHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmdbHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TmdbHomeViewModel::class.java)
        viewModel.getTopRated()
        setupObservables()
    }

    private fun setupObservables() {
        viewModel.onResultTopRated.observe(this, {
            it?.let { topRated ->
                setupRecyclerView(topRated.results)
            }
        })

        viewModel.onResultFailure.observe(this, {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupRecyclerView(movies: List<Result>) {
        binding.rvTmdbHome.apply {
            layoutManager = GridLayoutManager(this@TmdbHomeActivity, 2)
            adapter = TmdbHomeAdapter(movies) {
                val movieClicked = it
                //chamar outra activity ou fragment
            }
        }
    }
}