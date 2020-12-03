package com.github.cesar1287.desafiopicpayandroid.tmdb.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.cesar1287.desafiopicpayandroid.R
import com.github.cesar1287.desafiopicpayandroid.databinding.TmdbListItemBinding
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result

class TmdbHomeRoomAdapter (
    private val moviesList: List<Result>,
    private val onMovieClicked: (id: Int) -> Unit
) : RecyclerView.Adapter<TmdbHomeRoomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TmdbListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(moviesList[position], onMovieClicked)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class ViewHolder(
        private val binding: TmdbListItemBinding
    ): RecyclerView.ViewHolder(
       binding.root
    ) {

        fun bind(movie: Result?, onMovieClicked: (id: Int) -> Unit) = with(binding) {
            Glide.with(itemView.context)
                .load(movie?.posterPath)
                .placeholder(R.drawable.ic_ilustration)
                .into(ivTmdbHomePoster)
            tvTmdbName.text = movie?.title

            itemView.setOnClickListener {
                onMovieClicked(movie?.id ?: -1)
            }
        }
    }
}