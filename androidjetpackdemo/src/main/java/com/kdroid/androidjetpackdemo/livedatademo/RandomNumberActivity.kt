package com.kdroid.androidjetpackdemo.livedatademo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kdroid.androidjetpackdemo.R

class RandomNumberActivity : AppCompatActivity() {
    val TAG: String = RandomNumberActivity::class.simpleName.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)
        Log.d(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")

        val randomGeneratorViewModel: RandomGenerator =
            ViewModelProvider(this).get(RandomGenerator::class.java);

//        findViewById<TextView>(R.id.tv_random).setText(randomGeneratorViewModel.getNumber())
        randomGeneratorViewModel.randomNumber?.observe(
            this,
            Observer {
                Log.d(TAG,"it")
                findViewById<TextView>(R.id.tv_random).text = it })


    }
}