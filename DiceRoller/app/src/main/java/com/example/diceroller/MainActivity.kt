package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var imageView : ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.dice_image);

        val button : Button = findViewById(R.id.roll_button);

        button.setOnClickListener {
            roll();
        }
    }

    private fun roll() {
        val dice = when(Random.nextInt(6))
        {
            0 -> R.drawable.dice_1;
            1 -> R.drawable.dice_2;
            2 -> R.drawable.dice_3;
            3 -> R.drawable.dice_4;
            4 -> R.drawable.dice_5;
            5 -> R.drawable.dice_6;
            else ->R.drawable.empty_dice;
        }
        with(imageView) {
            setImageResource(dice)
        };

    }
}