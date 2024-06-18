package com.android.movieapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.os.persistableBundleOf
import com.android.movieapp.databinding.MovieItemBinding
import com.android.movieapp.model.room.Entity.Search
import com.bumptech.glide.Glide

class MovieAdapter(val context: Context,val list: List<Search>):BaseAdapter() {
    override fun getCount(): Int {
        return  list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding= MovieItemBinding.inflate(LayoutInflater.from(context),p2,false)
        val data=list[p0]
        Glide.with(context).load(data.Poster).into(binding.ivMovie)
        binding.tvName.text=data.Title
        return binding.root
    }
}