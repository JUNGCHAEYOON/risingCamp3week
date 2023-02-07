package com.example.risingcamp3week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingcamp3week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding         // 1.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   // 2.
        setContentView(binding.root)                            // 3.
    }

}