package com.kdroid.usecasedemoapplication.launchmodedemo

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.kdroid.usecasedemoapplication.databinding.ActivityABinding

class FirstActivity : BaseActivity() {
    lateinit var binding: ActivityABinding
    val TAG: String? = FirstActivity::class.java.canonicalName
    private var instanceCounter = 0
    private var currentInstanceValue = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStartActivityA.setOnClickListener {
            startActivity(
                this,
                FirstActivity::class.java
            )
        }
        binding.buttonStartActivityB.setOnClickListener {
            startActivity(
                this,
                SecondActivity::class.java
            )
        }
        binding.buttonStartActivityC.setOnClickListener {
            startActivity(
                this,
                ThirdActivity::class.java
            )
        }
        binding.buttonStartActivityD.setOnClickListener {
            startActivity(
                this,
                FourthActivity::class.java
            )
        }
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onResume() {
        super.onResume()
        binding.textViewTaskInfo.text = getAppTaskState()
    }
}
