package com.android.movieapp.view.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.movieapp.databinding.MovieItemBinding
import com.android.movieapp.model.room.Entity.Search
import com.android.movieapp.view.MovieAdapter
import com.bumptech.glide.Glide

class MovieRecycleAdapter(val context: Context,val list: List<Search>):RecyclerView.Adapter<MovieRecycleAdapter.MovieViewHolder>() {
    lateinit var binding: MovieItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        binding= MovieItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MovieViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val data=list[position]
        Glide.with(context).load(data.Poster).into(binding.ivMovie)
        binding.tvName.text=data.Title
    }
    class MovieViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    }
}