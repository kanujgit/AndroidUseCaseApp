package com.kdroid.usecasedemoapplication.coroutineretrofit

class PostRepository {

    suspend fun getPost(): ArrayList<PostModel> = RetrofitBuilder.api.getPost()

}