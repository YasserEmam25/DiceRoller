package com.yemam.dicerolleer

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allow the user to roll a dice and display the result in a textView
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rolledButton: Button = findViewById(R.id.btn_dice)

        rolledButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {
        // initialize a dice object and get the image reference
        val dice = Dice(6)
        val image = findViewById<ImageView>(R.id.imageView)

        // display a message to the user
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_LONG).show()

        val imageDrawable = when(dice.roll()){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image.setImageResource(imageDrawable)
    }
}

/**
 * this class is blueprint to the dice
 */

class Dice(private val sides: Int) {
    /**
     * this rolls the dice and returns a random number
     */
    fun roll(): Int {
        return (1..sides).random()
    }
}