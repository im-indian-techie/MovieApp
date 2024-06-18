package com.android.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.movieapp.model.repo.SearchRepo
import com.android.movieapp.model.room.Entity.Search
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val repo: SearchRepo):ViewModel() {
    val searchData: LiveData<List<Search>> get() = repo.searchData
    val errorData: LiveData<String> get() = repo.errorData
    val progressData: LiveData<Boolean> get() = repo.progressData

    fun getMovies(type:String,apikey:String,page:String,s:String)
    {
        viewModelScope.launch(Dispatchers.Main)
        {
            repo.getMovieList(type, apikey, page, s)
        }
    }
}