package com.kdroid.usecasedemoapplication.coroutineretrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// if view model take any params  so we need to create view model factory class:
class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
    private val TAG = PostViewModel::class.java.canonicalName
    val postMutableLiveData: MutableLiveData<ArrayList<PostModel>> = MutableLiveData()


//    fun getPost() = liveData(Dispatchers.IO) {
//        try {
//            emit(postRepository.getPost())
//        } catch (e: Exception) {
//            Log.d("ViewModel", e.toString())
//        }
//    }


    fun getPost() = viewModelScope.launch {
        try {
            val response = postRepository.getPost()
            postMutableLiveData.value = response
        } catch (e: Exception) {
            Log.d("ViewModel", e.toString())
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared() called")
    }
}