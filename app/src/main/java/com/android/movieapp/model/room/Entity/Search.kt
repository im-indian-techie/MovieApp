package com.android.movieapp.model.room.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SEARCH")
class Search (
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @ColumnInfo(name = "Title")
    val Title:String,

    @ColumnInfo(name = "Year")
    val Year:String,

    @ColumnInfo(name = "imdbID")
    val imdbID: String,

    @ColumnInfo(name = "Type")
    val Type: String,

    @ColumnInfo(name = "Poster")
    val Poster: String
)
