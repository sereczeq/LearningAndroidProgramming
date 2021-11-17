package com.example.colormyviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.apply {
            boxOneText.setOnClickListener{boxOneText.setBackgroundResource(R.color.purple_200)}
            boxTwoText.setOnClickListener{boxTwoText.setBackgroundResource(R.color.purple_200)}
            boxThreeText.setOnClickListener{boxThreeText.setBackgroundResource(R.color.purple_200)}
            boxFourText.setOnClickListener{boxFourText.setBackgroundResource(R.color.purple_200)}
            boxFiveText.setOnClickListener{boxFiveText.setBackgroundResource(R.color.purple_200)}

            redButton.setOnClickListener{boxThreeText.setBackgroundResource(R.color.my_red)}
            yellowButton.setOnClickListener{boxFourText.setBackgroundResource(R.color.my_yellow)}
            blueButton.setOnClickListener{boxFiveText.setBackgroundResource(R.color.my_blue)}
        }
    }
}