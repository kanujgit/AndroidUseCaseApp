package com.kdroid.usecasedemoapplication


import android.os.Bundle
import android.util.Log
import com.kdroid.usecasedemoapplication.databinding.ActivityMainBinding
import com.kdroid.usecasedemoapplication.fragments.Demo1Fragment
import com.kdroid.usecasedemoapplication.fragments.Demo2Fragment


class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    val TAG: String = MainActivity::class.simpleName.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate() called ")


        binding.add.setOnClickListener {
            addFragment(
                Demo1Fragment(),
                null,
                R.id.frame,
                true,
                Demo1Fragment::class.simpleName
            )
        }
        binding.replace.setOnClickListener {
            replaceFragment(
                Demo2Fragment(),
                null,
                R.id.frame,
                true,
                Demo2Fragment::class.simpleName
            )
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

}