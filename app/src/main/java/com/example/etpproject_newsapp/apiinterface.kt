package com.example.etpproject_newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface apiinterface {



    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String?,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String?
    ): Call<news?>?

    @GET("top-headlines")
    fun getCategoryNews(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String?
    ): Call<news?>?


}