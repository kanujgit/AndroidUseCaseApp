package com.kdroid.androidjetpackdemo.viewmodeldemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kdroid.androidjetpackdemo.R

class RandomNumberActivity : AppCompatActivity() {
    val TAG: String = RandomNumberActivity::class.simpleName.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)
        Log.d(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")

      //  var randomGenerator = RandomGenerator()

     //   findViewById<TextView>(R.id.tv_random).setText(randomGenerator.getNumber())


        val randomGeneratorViewModel:RandomGenerator = ViewModelProvider(this).get(RandomGenerator::class.java);

        findViewById<TextView>(R.id.tv_random).setText(randomGeneratorViewModel.getNumber())

    }
}