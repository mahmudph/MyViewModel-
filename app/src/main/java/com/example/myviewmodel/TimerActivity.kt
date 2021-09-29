package com.example.myviewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myviewmodel.databinding.ActivityTimerBinding
import com.example.myviewmodel.viewmodel.TimerViewModel

class TimerActivity : AppCompatActivity() {
    lateinit var binding: ActivityTimerBinding
    lateinit var timerViewModel: TimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timerViewModel = ViewModelProvider(this)[TimerViewModel::class.java]
        subscribed()
    }

    private fun subscribed() {
        val elapsedTimeObserver = Observer<Long?> { data ->
            val newText = this@TimerActivity.resources.getString(R.string.seconds, data)
            binding.timerTextview.text = newText
        }

        timerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}