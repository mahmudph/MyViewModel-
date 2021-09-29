package com.example.myviewmodel.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var results = 0

    fun calculate(w: String, h: String, l: String) {
        results = w.toInt() * h.toInt() * l.toInt()
    }
}