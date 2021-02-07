package com.kdroid.androidjetpackdemo.livedatademo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomGenerator : ViewModel() {

    val TAG: String = RandomGenerator::class.simpleName.toString()
    var randomNumber: MutableLiveData<String>? = null;

    init {
        Log.i("ScoreViewModel", "Final score is $randomNumber")
    }

    fun getNumber(): MutableLiveData<String> {
        Log.d(TAG, "getNumber");
        if (randomNumber == null) {
            randomNumber = MutableLiveData()
            createRandomNumber()
        }
        return randomNumber as MutableLiveData
    }

    private fun createRandomNumber(): String {
        Log.d(TAG, "Create new number");
        Log.i(TAG, "createRandomNumber: ${(0..10).random()}")
        return (0..10).random().toString()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared() called")
    }


}