package com.kdroid.usecasedemoapplication.coroutineretrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// because view model consume a parameter
class PostViewModelFactory(private val postRepository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }
}