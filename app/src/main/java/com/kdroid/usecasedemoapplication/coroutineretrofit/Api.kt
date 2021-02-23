package com.kdroid.usecasedemoapplication.coroutineretrofit

import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("posts")
    suspend fun getPost(): ArrayList<PostModel>
}