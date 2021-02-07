package com.kdroid.androidjetpackdemo.viewmodeldemo

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

public class RandomGenerator : ViewModel() {

    val TAG: String = RandomGenerator::class.simpleName.toString()

    var randomNumber: String? = null;

    fun getNumber(): String {
        Log.d(TAG, "getNumber");
        if (randomNumber == null) {
            randomNumber = createRandomNumber();
        }
        return randomNumber as String
    }

    fun createRandomNumber() : String{
        Log.d(TAG, "Create new number");
        Log.i(TAG, "createRandomNumber: ${(0..10).random()}")
        return (0..10).random().toString()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared() called")
    }


}