package com.github.cesar1287.desafiopicpayandroid

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_list_item.view.*

class MainAdapter(
    private val userList: List<User>,
    private val mainAdapterListener: MainAdapterListener
) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        Log.i("RecyclerView", "onCreateViewHolder")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        Log.i("RecyclerView", "onBindViewHolder - $position")
        holder.bind(userList[position], mainAdapterListener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User, mainAdapterListener: MainAdapterListener) = with(itemView) {
            //todo carregar imagem

            if (user.cash > 0.0) {
                tvMainItemCash.text = context.getString(R.string.main_adapter_cash, user.cash)
                tvMainItemCash.isVisible = true
            }

            tvMainItemUser.text = user.userId
            tvMainItemName.text = user.userName

            vgMainItemContainer.setOnClickListener {
                mainAdapterListener.onItemClicked(this@ViewHolder.adapterPosition)
            }
        }
    }
}