package com.example.firstAndroid.ActivityLifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstAndroid.R

class NormalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_life_cycle)
    }
}