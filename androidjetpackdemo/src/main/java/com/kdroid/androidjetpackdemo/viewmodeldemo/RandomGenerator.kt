package com.kdroid.androidjetpackdemo.viewmodeldemo

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

public class RandomGenerator : ViewModel() {

    val TAG: String = RandomGenerator::class.simpleName.toString()
    var timer: CountDownTimer? = null

    val postMutableLiveData: MutableLiveData<String> = MutableLiveData()


    var randomNumber: String? = null;

    fun getNumber() {
        Log.d(TAG, "getNumber");
        if (randomNumber == null) {
            randomNumber = createRandomNumber();
        }
        val data = randomNumber as String
        postMutableLiveData.value = data
    }

    fun createRandomNumber(): String {
        Log.d(TAG, "Create new number");
        Log.i(TAG, "createRandomNumber: ${(0..10).random()}")
        return (0..10).random().toString()
    }

    fun getTimerData() {
        if (timer  == null) {
            timer = object : CountDownTimer(100000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    postMutableLiveData.value = (millisUntilFinished / 1000).toInt().toString()
                    Log.d(TAG, (millisUntilFinished / 1000).toInt().toString());
                }

                override fun onFinish() {}
            }
            (timer as CountDownTimer).start()
        }


    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared() called")
    }


}