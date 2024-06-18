package com.android.movieapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.movieapp.model.api.APIConstatnts
import com.android.movieapp.model.api.APIInterface
import com.android.movieapp.model.room.Database
import com.android.movieapp.model.room.dao.SearchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providesRetrofit():Retrofit
    {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient=OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        return Retrofit.Builder().baseUrl(APIConstatnts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit):APIInterface
    {
        return retrofit.create(APIInterface::class.java)
    }
    @Singleton
    @Provides
    fun providesDatabase(context: Context):Database{
        return Room.databaseBuilder(context,Database::class.java,"MY_DATABASE").build()
    }

    @Singleton
    @Provides
    fun providesSearcDao(database: Database):SearchDao{
        return database.searchDao()
    }
}