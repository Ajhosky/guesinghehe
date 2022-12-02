package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {
            var maxNumber = binding.editTextNumber.text
            val intent = Intent(this, GuesingActivity::class.java)
            var randomValue = Random.nextInt(0, maxNumber.toString().toInt())
            intent.putExtra("maxNuber", maxNumber)
            intent.putExtra("randomValue", randomValue)
            startActivity(intent)
        }
    }
}