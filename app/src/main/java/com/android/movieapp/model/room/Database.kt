package com.android.movieapp.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.movieapp.model.room.Entity.Search
import com.android.movieapp.model.room.dao.SearchDao

@Database(entities = [Search::class], version = 1, exportSchema = false)
abstract class Database:RoomDatabase() {
    abstract fun searchDao():SearchDao
}