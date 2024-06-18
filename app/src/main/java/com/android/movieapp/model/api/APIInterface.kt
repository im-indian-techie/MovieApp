package com.android.movieapp.model.api

import com.android.movieapp.model.pojo.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
   @GET(APIConstatnts.GET_MOVIES)
   suspend fun getMovies(@Query("type")type:String,@Query("apikey")apikey:String,@Query("page")page:String,@Query("s")s:String):Response<MovieResponse>
}