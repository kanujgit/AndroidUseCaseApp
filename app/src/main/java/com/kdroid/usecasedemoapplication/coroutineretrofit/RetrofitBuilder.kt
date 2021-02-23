package com.kdroid.usecasedemoapplication.coroutineretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }
}