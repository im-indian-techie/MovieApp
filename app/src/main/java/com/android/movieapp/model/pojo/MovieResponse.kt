package com.android.movieapp.model.pojo

import com.android.movieapp.model.room.Entity.Search
import com.google.gson.annotations.SerializedName
import java.io.Serial

class MovieResponse(
    @SerializedName("Search")
    val Search:List<Search>,

    @SerializedName("totalResults")
    val totalResults:String,

    @SerializedName("Response")
    val Response:Boolean
)