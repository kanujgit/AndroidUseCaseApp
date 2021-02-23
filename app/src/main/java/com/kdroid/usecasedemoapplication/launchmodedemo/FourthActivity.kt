package com.kdroid.usecasedemoapplication.launchmodedemo

import android.os.Bundle
import com.kdroid.usecasedemoapplication.databinding.ActivityDBinding

class FourthActivity : BaseActivity() {
    lateinit var binding: ActivityDBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDBinding.inflate(layoutInflater)
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

    override fun onResume() {
        super.onResume()
        binding.textViewTaskInfo.text = getAppTaskState()
    }
}