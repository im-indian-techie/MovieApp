package com.android.movieapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.movieapp.R
import com.android.movieapp.databinding.ActivityMainBinding
import com.android.movieapp.model.api.APIConstatnts
import com.android.movieapp.model.room.Entity.Search
import com.android.movieapp.view.MovieAdapter
import com.android.movieapp.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val activity=this
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: SearchViewModel
    lateinit var adapter: MovieRecycleAdapter
    val list:ArrayList<Search> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
      viewModel=ViewModelProvider(this)[SearchViewModel::class.java]
      viewModel.searchData.observe(activity, Observer {
          if(it.isNotEmpty())
          {
              list.clear()
              list.addAll(it)
              adapter.notifyDataSetChanged()
          }
      })
        adapter= MovieRecycleAdapter(activity,list)
        binding.gvMian.adapter=adapter
        binding.gvMian.layoutManager= GridLayoutManager(activity, 2, GridLayoutManager.HORIZONTAL, false)
        adapter.notifyDataSetChanged()
        viewModel.getMovies("movie",APIConstatnts.API_KEY,"1","guardians")
    }
}