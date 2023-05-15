package com.example.etpproject_newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apiutilities {

    companion object {
        private var retrofit: Retrofit? = null
        var BASE_URL = "https://newsapi.org/v2/"
        fun getApiInterface(): ApiInterface {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ApiInterface::class.java)
        }
    }

}