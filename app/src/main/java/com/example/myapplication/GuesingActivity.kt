package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityGuesingBinding
import kotlin.random.Random

class GuesingActivity : AppCompatActivity() {
    lateinit var binding: ActivityGuesingBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guesing)
        binding = ActivityGuesingBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        var maxNumber = binding.
        val maxNumber = intent.getIntExtra("maxNumber",0)
        var randomValue = intent.getIntExtra("randomValue", 0)
        var hint = "";
//        binding.textView3.setText("find x\n" +
//                "x < "+ maxNumber.toString())
        binding.enterBtn.setOnClickListener(){
            var answer = binding.editTextAnswer.text.toString().toInt()
            binding.textView3.setText("find x\n" + "x < "+ maxNumber.toString())
            if(answer > maxNumber){
                binding.higherLower.setText("Error, your answer is higher than max Number")
            }
            if (answer>randomValue){
                hint += answer.toString() +" > answer\n"
                binding.higherLower.setText(hint)
                //binding.higherLower.setText(answer.toString() +" > answer" )
            }else if (answer < randomValue){
                hint += answer.toString() +" < answer\n"
                binding.higherLower.setText(hint)
                //binding.higherLower.setText(answer.toString() +" < answer" )
            }else if(answer == randomValue){
                binding.higherLower.setText("brawo zgales")
            }

        }
        binding.returnBtn.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}