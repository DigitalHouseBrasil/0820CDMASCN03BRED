package com.github.cesar1287.desafiopicpayandroid

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_list_item.view.*

class MainAdapter(
    private val userList: List<User>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        Log.i("RecyclerView", "onCreateViewHolder")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        Log.i("RecyclerView", "onBindViewHolder - $position")
        holder.bind(userList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User, onItemClicked: (Int) -> Unit) = with(itemView) {

            Glide.with(itemView.context).load(user.userProfileAvatar).into(ivMainItemAvatar)

            if (user.cash > 0.0) {
                tvMainItemCash.text = context.getString(R.string.main_adapter_cash, user.cash)
                tvMainItemCash.isVisible = true
            }

            tvMainItemUser.text = user.userId
            tvMainItemName.text = user.userName

            vgMainItemContainer.setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }
    }
}