package com.kdroid.androidjetpackdemo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.simpleName.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate() called")
        lifecycle.addObserver(MainActivityObserver())
        val text = findViewById<TextView>(R.id.text)
        text.setOnClickListener {
            val intent = Intent(this,MainActivityCopy::class.java)
            startActivity(intent)
        }
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