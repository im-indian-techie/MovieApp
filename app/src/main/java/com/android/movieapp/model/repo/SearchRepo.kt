package com.android.movieapp.model.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.movieapp.model.api.APIInterface
import com.android.movieapp.model.room.Entity.Search
import retrofit2.http.Query
import javax.inject.Inject

class SearchRepo @Inject constructor(val apiInterface: APIInterface) {
    val _searchData=MutableLiveData<List<Search>>()
    val _errorData=MutableLiveData<String>()
    val _progressData=MutableLiveData<Boolean>()


    val searchData:LiveData<List<Search>> get() = _searchData
    val errorData:LiveData<String> get() = _errorData
    val progressData:LiveData<Boolean> get() = _progressData

    suspend fun getMovieList(type:String,apikey:String,page:String,s:String)
    {
        _progressData.value=true
        val response=apiInterface.getMovies(type, apikey, page, s)
        if (response.isSuccessful && response.body()!=null)
        {
            _progressData.value=false
            _searchData.value=response.body()!!.Search
        }
        else
        {
            _progressData.value=false
            _errorData.value=response.message()
        }
    }
}