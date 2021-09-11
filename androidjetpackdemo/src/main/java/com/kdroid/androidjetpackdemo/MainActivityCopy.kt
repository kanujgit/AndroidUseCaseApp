package com.kdroid.androidjetpackdemo

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivityCopy : AppCompatActivity() {
    val TAG: String = MainActivityCopy::class.simpleName.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate() called")
        lifecycle.addObserver(MainActivityObserver())
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume() called")

        //recreate()
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart() called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState() called")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.i(TAG, "onSaveInstanceState: called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState: outState")
    }
}