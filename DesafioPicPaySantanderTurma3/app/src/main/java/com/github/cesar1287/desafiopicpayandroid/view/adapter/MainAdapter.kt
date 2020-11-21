package com.github.cesar1287.desafiopicpayandroid.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.cesar1287.desafiopicpayandroid.databinding.MainListItemBinding
import com.github.cesar1287.desafiopicpayandroid.model.UsersItem

class MainAdapter(
    private val userList: List<UsersItem>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("RecyclerView", "onCreateViewHolder")
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MainListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("RecyclerView", "onBindViewHolder - $position")
        holder.bind(userList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(
        private val binding: MainListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UsersItem, onItemClicked: (Int) -> Unit) = with(itemView) {

            Glide.with(itemView.context).load(user.img).into(binding.ivMainItemAvatar)
            binding.tvMainItemUser.text = user.username
            binding.tvMainItemName.text = user.name

            binding.vgMainItemContainer.setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }
    }
}