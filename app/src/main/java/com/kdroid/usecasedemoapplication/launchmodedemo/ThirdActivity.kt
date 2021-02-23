package com.kdroid.usecasedemoapplication.launchmodedemo

import android.os.Bundle
import com.kdroid.usecasedemoapplication.databinding.ActivityCBinding

class ThirdActivity : BaseActivity() {
    lateinit var binding: ActivityCBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCBinding.inflate(layoutInflater)
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